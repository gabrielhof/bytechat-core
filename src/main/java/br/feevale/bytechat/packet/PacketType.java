package br.feevale.bytechat.packet;

public enum PacketType {

	ACK(Ack.class),
	MESSAGE(Message.class),
	;
	
	private Class<? extends Packet> packetClass;
	
	PacketType(Class<? extends Packet> packetClass) {
		this.packetClass = packetClass;
	}
	
	public Class<? extends Packet> getPacketClass() {
		return packetClass;
	}
	
}
