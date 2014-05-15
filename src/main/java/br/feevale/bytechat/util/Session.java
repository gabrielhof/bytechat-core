package br.feevale.bytechat.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import br.feevale.bytechat.exception.ConnectionException;
import br.feevale.bytechat.exception.PacketException;
import br.feevale.bytechat.packet.Packet;
import br.feevale.bytechat.server.connector.Connection;
import br.feevale.bytechat.server.listener.SessionListener;

public class Session implements Runnable {
	
	private User user;
	private Connection connection;
	
	private List<SessionListener> listeners = new ArrayList<SessionListener>();
	
	private Executor eventDispatcher = Executors.newSingleThreadExecutor();
	private Thread thread;
	
	public Session(User user, Connection connection) {
		this.user = user;
		this.connection = connection;
	}
	
	public User getUser() {
		return user;
	}
	
	public void send(Packet packet) throws PacketException {
		connection.send(packet);
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void addListener(SessionListener listener) {
		listeners.add(listener);
	}
	
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void stop() throws ConnectionException {
		thread = null;
		
		if (!connection.isClosed()) {
			connection.close();
		}
	}
	
	public void run() {
		try {
			while (thread != null) {
				Packet packet = connection.receive();
				firePacketReceived(packet);
			}
		} catch (PacketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void firePacketReceived(final Packet packet) {
		eventDispatcher.execute(new Runnable() {
			public void run() {
				for (SessionListener listener : listeners) {
					listener.packetReceived(Session.this, packet);
				}
			}
		});
	}

}
