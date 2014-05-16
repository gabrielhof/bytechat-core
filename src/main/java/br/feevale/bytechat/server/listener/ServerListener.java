package br.feevale.bytechat.server.listener;

import br.feevale.bytechat.exception.ServerException;
import br.feevale.bytechat.util.Session;

public interface ServerListener {

	public void newSession(Session newSession) throws ServerException;
	
	public void endedSession(Session endedSession) throws ServerException;
	
}
