package br.feevale.bytechat.client.factory;

import java.io.IOException;
import java.net.Socket;

import br.feevale.bytechat.builder.BindBuilder;
import br.feevale.bytechat.config.Configuration;
import br.feevale.bytechat.exception.PacketFailedException;
import br.feevale.bytechat.exception.ChatException;
import br.feevale.bytechat.exception.ClientException;
import br.feevale.bytechat.exception.ServerNotRespondingException;
import br.feevale.bytechat.packet.Fail;
import br.feevale.bytechat.packet.Packet;
import br.feevale.bytechat.protocol.Connection;
import br.feevale.bytechat.protocol.SocketConnection;
import br.feevale.bytechat.util.Session;
import br.feevale.bytechat.util.User;

public class SocketSessionFactory extends ClientSessionFactory {

	@Override
	public Session create(Configuration configuration, User user) throws ClientException {
		try {
			Socket socket = new Socket(configuration.getHost(), configuration.getPort());
			
			Connection connection = new SocketConnection(socket);
			connection.send(BindBuilder.create().user(user).getBind());
			
			Packet response = connection.receive();
			
			if (response instanceof Fail) {
				connection.close();
				throw new PacketFailedException((Fail) response);
			}
			
			return new Session(user, connection);
		} catch (IOException e) {
			throw new ServerNotRespondingException(String.format("Servidor não respondendo no endereço %s:%d", configuration.getHost(), configuration.getPort()), e);
		} catch (PacketFailedException e) {
			throw e;
		} catch (ChatException e) {
			throw new ClientException(e);
		}
	}

}
