package br.feevale.bytechat.server;

import br.feevale.bytechat.config.Configuration;
import br.feevale.bytechat.server.exception.ServerException;

public interface ServerConnectorFactory {

	public ServerConnector create(Configuration configuration) throws ServerException;
	
}
