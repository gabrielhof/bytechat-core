package br.feevale.bytechat.client;

import br.feevale.bytechat.config.Configuration;
import br.feevale.bytechat.exception.ClientException;
import br.feevale.bytechat.util.Session;
import br.feevale.bytechat.util.User;

public interface ChatClient {

	public void setConfiguration(Configuration configuration) throws ClientException;
	
	public Configuration getConfiguration();
	
	public void setUser(User user);
	
	public User getUser();
	
	public Session getSession() throws ClientException;
	
	public void start() throws ClientException;
	
	public void stop() throws ClientException;
	
	public boolean isRunning();
	
}
