package br.feevale.bytechat.builder;

import br.feevale.bytechat.packet.Fail;
import br.feevale.bytechat.packet.FailType;
import br.feevale.bytechat.packet.Packet;

public class FailBuilder {
	
	private Fail fail = new Fail();
	
	private FailBuilder() {}
	
	public FailBuilder fail(Packet packet) {
		fail.setFailPacket(packet);
		return this;
	}
	
	public FailBuilder because(FailType reason) {
		fail.setFailType(reason);
		return this;
	}
	
	public Fail getFail() {
		return fail;
	}
	
	public static FailBuilder create() {
		return new FailBuilder();
	}
	
}
