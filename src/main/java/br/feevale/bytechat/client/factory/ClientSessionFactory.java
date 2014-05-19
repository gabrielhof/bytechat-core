package br.feevale.bytechat.client.factory;

import br.feevale.bytechat.config.Configuration;
import br.feevale.bytechat.exception.ClientException;
import br.feevale.bytechat.util.Session;
import br.feevale.bytechat.util.User;

public abstract class ClientSessionFactory {

	public abstract Session create(Configuration configuration, User user) throws ClientException;
	
	public static ClientSessionFactory getDefault() {
		return new SocketSessionFactory();
	}
	
}
