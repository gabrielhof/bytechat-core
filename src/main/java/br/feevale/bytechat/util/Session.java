package br.feevale.bytechat.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import br.feevale.bytechat.exception.ConnectionException;
import br.feevale.bytechat.exception.PacketException;
import br.feevale.bytechat.listener.SessionListener;
import br.feevale.bytechat.packet.Packet;
import br.feevale.bytechat.protocol.Connection;

public class Session {
	
	private User user;
	private Connection connection;
	
	private List<SessionListener> listeners = new ArrayList<SessionListener>();
	
	private Thread connectionObserverThread;
	private Executor eventDispatcher = Executors.newSingleThreadExecutor();
	
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
		if (connectionObserverThread == null) {
			connectionObserverThread = new Thread(new SessionConnectionObserver());
			connectionObserverThread.start();
		}
	}
	
	public void stop() throws ConnectionException {
		if (!connection.isClosed()) {
			connection.close();
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
	
	class SessionConnectionObserver implements Runnable {

		@Override
		public void run() {
			try {
				while (!connection.isClosed()) {
					Packet packet = connection.receive();
					firePacketReceived(packet);
				}
			} catch (PacketException e) {
				e.printStackTrace();
			}
		}
		
	}

}
