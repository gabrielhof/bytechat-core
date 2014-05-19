package br.feevale.bytechat.packet;

public class Success implements Packet {

	private static final long serialVersionUID = -4092841145319337316L;
	
	private Packet sucessPacket;
	
	public Success() {
		this(null);
	}
	
	public Success(Packet successPacket) {
		this.sucessPacket = successPacket;
	}
	
	public Packet getSucessPacket() {
		return sucessPacket;
	}

	public void setSucessPacket(Packet sucessPacket) {
		this.sucessPacket = sucessPacket;
	}

	@Override
	public PacketType getType() {
		return PacketType.SUCCESS;
	}

}
