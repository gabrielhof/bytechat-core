package br.feevale.bytechat.builder;

import br.feevale.bytechat.packet.Ack;
import br.feevale.bytechat.util.User;

public class AckBuilder {

	private Ack ack = new Ack();
	
	private AckBuilder() {}
	
	public AckBuilder user(User user) {
		ack.setUser(user);
		return this;
	}
	
	public Ack getAck() {
		return ack;
	}
	
	public static AckBuilder create() {
		return new AckBuilder();
	}
	
}
