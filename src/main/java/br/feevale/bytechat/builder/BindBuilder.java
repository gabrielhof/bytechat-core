package br.feevale.bytechat.builder;

import br.feevale.bytechat.packet.Bind;
import br.feevale.bytechat.util.User;

public class BindBuilder {

	private Bind ack = new Bind();
	
	private BindBuilder() {}
	
	public BindBuilder user(User user) {
		ack.setUser(user);
		return this;
	}
	
	public Bind getBind() {
		return ack;
	}
	
	public static BindBuilder create() {
		return new BindBuilder();
	}
	
}
