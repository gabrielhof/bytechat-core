package br.feevale.bytechat.listener;

import br.feevale.bytechat.packet.Packet;
import br.feevale.bytechat.util.Session;

public interface SessionListener {
	
	public void packetReceived(Session session, Packet packet);
	
	public void sessionEnded(Session session);

}
