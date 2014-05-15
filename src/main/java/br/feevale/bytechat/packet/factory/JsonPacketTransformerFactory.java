package br.feevale.bytechat.packet.factory;

import br.feevale.bytechat.packet.transformer.JsonPacketTransformer;
import br.feevale.bytechat.packet.transformer.PacketTransformer;

public class JsonPacketTransformerFactory extends PacketTransformerFactory {

	@Override
	public PacketTransformer create() {
		return new JsonPacketTransformer();
	}

}
