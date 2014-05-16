package br.feevale.bytechat.protocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.commons.lang.StringUtils;

import br.feevale.bytechat.exception.ConnectionException;
import br.feevale.bytechat.exception.PacketException;
import br.feevale.bytechat.factory.PacketTransformerFactory;
import br.feevale.bytechat.packet.Packet;
import br.feevale.bytechat.util.ThreadUtils;

public class SocketConnection implements Connection {

	private Socket socket;
	
	private BufferedReader reader;
	private BufferedWriter writer;
	
	private PacketTransformer packetTransformer;
	
	public SocketConnection(Socket socket) throws ConnectionException {
		this.socket = socket;
		
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			packetTransformer = PacketTransformerFactory.getDefault().create();
		} catch (IOException e) {
			throw new ConnectionException(e);
		}
	}

	@Override
	public BufferedReader getReader() {
		return reader;
	}

	@Override
	public BufferedWriter getWriter() {
		return writer;
	}
	
	@Override
	public void send(Packet packet) throws PacketException {
		try {
			String packetString = packetTransformer.transform(packet);
			writer.write(String.format("%s\n", packetString));
			writer.flush();
		} catch (IOException e) {
			throw new PacketException(e);
		}
	}
	
	@Override
	public Packet receive() throws PacketException {
		try {
			ThreadUtils.sleep(100);
			String packetString = reader.readLine();
			
			if (StringUtils.isNotBlank(packetString)) {
				return packetTransformer.fromString(packetString);
			} else {
				return receive();
			}
		} catch (SocketTimeoutException e) {
			return receive();
		} catch (IOException e) {
			throw new PacketException(e);
		}
	}

	@Override
	public void close() throws ConnectionException {
		try {
			socket.close();
		} catch (IOException e) {
			throw new ConnectionException(e);
		}
	}

	@Override
	public boolean isClosed() {
		return socket.isClosed();
	}
}
