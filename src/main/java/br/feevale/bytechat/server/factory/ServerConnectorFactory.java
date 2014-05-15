package br.feevale.bytechat.server.factory;

import br.feevale.bytechat.config.Configuration;
import br.feevale.bytechat.exception.ServerException;
import br.feevale.bytechat.server.connector.ServerConnector;

public interface ServerConnectorFactory {

	public ServerConnector create(Configuration configuration) throws ServerException;
	
}
