package br.feevale.bytechat.server.listener;

import br.feevale.bytechat.util.Session;

public interface SessionListener {
	
	public void messageReceived(Session session, String message);

}
