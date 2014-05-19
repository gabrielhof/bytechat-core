package br.feevale.bytechat.builder;

import br.feevale.bytechat.packet.Unbind;
import br.feevale.bytechat.util.User;

public class UnbindBuilder {
	
	private Unbind unbind = new Unbind();
	
	private UnbindBuilder() {}
	
	public UnbindBuilder user(User user) {
		unbind.setUser(user);
		return this;
	}
	
	public Unbind getUnbind() {
		return unbind;
	}
	
	public static UnbindBuilder create() {
		return new UnbindBuilder();
	}

}
