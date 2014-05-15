package br.feevale.bytechat.server.listener;

import br.feevale.bytechat.packet.Packet;
import br.feevale.bytechat.util.Session;

public interface SessionListener {
	
	public void packetReceived(Session session, Packet packet);

}
