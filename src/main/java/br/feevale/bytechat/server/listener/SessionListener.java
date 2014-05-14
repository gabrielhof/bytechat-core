package br.feevale.bytechat.server.listener;

import br.feevale.bytechat.server.exception.ServerException;
import br.feevale.bytechat.util.Session;

public interface SessionListener {
	
	public void messageReceived(Session session, String message) throws ServerException;

}
