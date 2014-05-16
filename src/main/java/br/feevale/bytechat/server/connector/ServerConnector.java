package br.feevale.bytechat.server.connector;

import br.feevale.bytechat.config.Configuration;
import br.feevale.bytechat.exception.ServerException;
import br.feevale.bytechat.protocol.Connection;

public interface ServerConnector {

	public void init(Configuration configuration) throws ServerException;
	
	public Connection accept() throws ServerException;
	
	public void close() throws ServerException;
	
	public boolean isClosed();
	
}
