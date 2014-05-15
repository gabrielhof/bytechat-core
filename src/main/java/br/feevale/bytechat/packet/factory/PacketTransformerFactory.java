package br.feevale.bytechat.packet.factory;

import br.feevale.bytechat.packet.transformer.PacketTransformer;

public abstract class PacketTransformerFactory {

	private static PacketTransformerFactory INSTANCE;
	
	public abstract PacketTransformer create();
	
	public static PacketTransformerFactory getDefault() {
		if (INSTANCE == null) {
			INSTANCE = new JsonPacketTransformerFactory();
		}
		
		return INSTANCE;
	}
	
}
