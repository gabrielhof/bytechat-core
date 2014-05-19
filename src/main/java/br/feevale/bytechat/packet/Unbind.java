package br.feevale.bytechat.packet;

import br.feevale.bytechat.util.User;

public class Unbind implements Packet {

	private static final long serialVersionUID = 4343836206194571841L;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public PacketType getType() {
		return PacketType.UNBIND;
	}

}
