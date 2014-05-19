package br.feevale.bytechat.server.factory;

import br.feevale.bytechat.config.Configuration;
import br.feevale.bytechat.exception.ServerException;
import br.feevale.bytechat.server.connector.ServerConnector;

public abstract class ServerConnectorFactory {

	public abstract ServerConnector create(Configuration configuration) throws ServerException;
	
	public static ServerConnectorFactory getDefault() {
		return new ServerSocketConnectorFactory();
	}
	
}
