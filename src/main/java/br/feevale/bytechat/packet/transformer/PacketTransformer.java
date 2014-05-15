package br.feevale.bytechat.packet.transformer;

import br.feevale.bytechat.packet.Packet;


public interface PacketTransformer {
	
	public Packet fromString(String s);
	
	public String transform(Packet packet);

}
