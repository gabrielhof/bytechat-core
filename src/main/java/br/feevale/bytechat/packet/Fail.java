package br.feevale.bytechat.packet;

public class Fail implements Packet {

	private static final long serialVersionUID = -3257779588659563362L;
	
	private Packet failPacket;
	private FailType failType;
	
	public Packet getFailPacket() {
		return failPacket;
	}

	public void setFailPacket(Packet failPacket) {
		this.failPacket = failPacket;
	}

	public FailType getFailType() {
		return failType;
	}

	public void setFailType(FailType failType) {
		this.failType = failType;
	}

	@Override
	public PacketType getType() {
		return PacketType.FAIL;
	}

}
