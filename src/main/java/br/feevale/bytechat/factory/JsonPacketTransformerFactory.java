package br.feevale.bytechat.factory;

import br.feevale.bytechat.protocol.JsonPacketTransformer;
import br.feevale.bytechat.protocol.PacketTransformer;

public class JsonPacketTransformerFactory extends PacketTransformerFactory {

	@Override
	public PacketTransformer create() {
		return new JsonPacketTransformer();
	}

}
