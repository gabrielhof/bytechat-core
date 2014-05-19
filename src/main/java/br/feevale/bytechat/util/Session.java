package br.feevale.bytechat.util;

import java.lang.reflect.Method;
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
		try {
			connection.send(packet);
		} catch (PacketException e) {
			if (connection.isClosed()) {
				stop();
				return;
			}
			
			throw e;
		}
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
	
	public void stop() {
		if (!connection.isClosed()) {
			try {
				connection.close();
			} catch (ConnectionException e) {}
		}
		
		connectionObserverThread = null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Session) {
			Session session = (Session) obj;
			
			if (session.getUser() != null && getUser() != null) {
				return session.getUser().equals(getUser());
			}
			
			return false;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return getUser() == null ? super.hashCode() : getUser().hashCode();
	}
	
	protected void firePacketReceived(final Packet packet) {
		Method method = ReflectionUtils.findMethod(SessionListener.class, "packetReceived", Session.class, Packet.class);
		ReflectionUtils.invokeEachItemInBackGround(eventDispatcher, listeners, method, this, packet);
	}
	
	protected void fireSessionEnded() {
		Method method = ReflectionUtils.findMethod(SessionListener.class, "sessionEnded", Session.class);
		ReflectionUtils.invokeEachItemInBackGround(eventDispatcher, listeners, method, this);
	}
	
	class SessionConnectionObserver implements Runnable {

		@Override
		public void run() {
			while (!connection.isClosed()) {
				try {
					Packet packet = connection.receive();
					firePacketReceived(packet);
				} catch (PacketException e) {
					if (!connection.isClosed()) {
						e.printStackTrace();
					}
				}
			}
			
			stop();
			fireSessionEnded();
		}
		
	}

}
