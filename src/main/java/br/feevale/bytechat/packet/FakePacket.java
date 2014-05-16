package br.feevale.bytechat.packet;

public class FakePacket implements Packet {

	private static final long serialVersionUID = -5517312003105710341L;
	
	private PacketType type;
	
	public void setType(PacketType packetType) {
		this.type = packetType;
	}
	
	@Override
	public PacketType getType() {
		return type;
	}
	
}
