package br.feevale.bytechat.packet;

import br.feevale.bytechat.util.User;

public class Ack implements Packet {

	private static final long serialVersionUID = -3876165168891734832L;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public PacketType getType() {
		return PacketType.ACK;
	}

}
