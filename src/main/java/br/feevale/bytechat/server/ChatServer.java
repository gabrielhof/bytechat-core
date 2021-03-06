package br.feevale.bytechat.server;

import java.util.Collection;
import java.util.List;

import br.feevale.bytechat.config.Configuration;
import br.feevale.bytechat.exception.ServerException;
import br.feevale.bytechat.server.connector.ServerConnector;
import br.feevale.bytechat.server.listener.ServerListener;
import br.feevale.bytechat.util.Session;

public interface ChatServer {

	public void start() throws ServerException;
	
	public void stop() throws ServerException;
	
	public boolean isRunning();
	
	public void setConfiguration(Configuration configuration) throws ServerException;
	
	public Configuration getConfiguration();
	
	public ServerConnector getConnector();
	
	public boolean addSession(Session session) throws ServerException;
	
	public boolean removeSession(Session session) throws ServerException;
	
	public Collection<Session> getSessions();
	
	public boolean addServerListener(ServerListener serverListener);
	
	public boolean removeServerListener(ServerListener serverListener);
	
	public List<ServerListener> getServerListeners();
	
}
