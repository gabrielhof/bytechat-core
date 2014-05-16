package br.feevale.bytechat.factory;

import br.feevale.bytechat.protocol.PacketTransformer;

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
