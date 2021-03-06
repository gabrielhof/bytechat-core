package br.feevale.bytechat.server.connector;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.feevale.bytechat.config.Configuration;
import br.feevale.bytechat.exception.ConnectionException;
import br.feevale.bytechat.exception.ConnectorAlreadyInitializedException;
import br.feevale.bytechat.exception.ServerException;
import br.feevale.bytechat.protocol.Connection;
import br.feevale.bytechat.protocol.SocketConnection;

public class ServerSocketConnector implements ServerConnector {

	private ServerSocket serverSocket;
	
	@Override
	public void init(Configuration configuration) throws ServerException {
		try {
			if (serverSocket != null && !serverSocket.isClosed()) {
				throw new ConnectorAlreadyInitializedException(String.format("Connector ja inicializado na porta %d", configuration.getPort()));
			}
			
			serverSocket = new ServerSocket(configuration.getPort());
		} catch (IOException e) {
			throw new ServerException(e);
		}
	}

	@Override
	public Connection accept() throws ServerException {
		try {
			Socket socket = serverSocket.accept();
//			socket.setSoTimeout(1000);
			
			return new SocketConnection(socket);
		} catch (ConnectionException e) {
			return accept();
		} catch (Exception e) {
			throw new ServerException(e);
		}
	}
	
	@Override
	public void close() throws ServerException {
		try {
			serverSocket.close();
			serverSocket = null;
		} catch (IOException e) {
			throw new ServerException(e);
		}
	}
	
	@Override
	public boolean isClosed() {
		return serverSocket == null || serverSocket.isClosed();
	}

}
