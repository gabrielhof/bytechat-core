package br.feevale.bytechat.packet;

public enum PacketType {

	BIND(Bind.class),
	UNBIND(Unbind.class),
	MESSAGE(Message.class), 
	USER_LIST(UserList.class),
	;
	
	private Class<? extends Packet> packetClass;
	
	PacketType(Class<? extends Packet> packetClass) {
		this.packetClass = packetClass;
	}
	
	public Class<? extends Packet> getPacketClass() {
		return packetClass;
	}
	
}
