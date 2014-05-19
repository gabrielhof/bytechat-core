package br.feevale.bytechat.packet;

import java.util.List;

import br.feevale.bytechat.util.User;

public class UserList implements Packet {

	private static final long serialVersionUID = -2073242085293056832L;
	
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Override
	public PacketType getType() {
		return PacketType.USER_LIST;
	}

}
