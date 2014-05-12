package br.feevale.bytechat.server.listener;

import br.feevale.bytechat.util.Session;

public interface ServerListener {

	
	public void newSession(Session newSession);
	
}
