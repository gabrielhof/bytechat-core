package br.feevale.bytechat.server.factory;

import br.feevale.bytechat.config.Configuration;
import br.feevale.bytechat.server.connector.ServerConnector;
import br.feevale.bytechat.server.exception.ServerException;

public interface ServerConnectorFactory {

	public ServerConnector create(Configuration configuration) throws ServerException;
	
}
