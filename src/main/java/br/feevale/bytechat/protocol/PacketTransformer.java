package br.feevale.bytechat.protocol;

import br.feevale.bytechat.packet.Packet;


public interface PacketTransformer {
	
	public Packet fromString(String s);
	
	public String transform(Packet packet);

}
