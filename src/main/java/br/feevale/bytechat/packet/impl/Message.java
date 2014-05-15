package br.feevale.bytechat.packet.impl;

import java.util.List;

import br.feevale.bytechat.packet.Packet;
import br.feevale.bytechat.packet.PacketType;
import br.feevale.bytechat.util.User;

public class Message implements Packet {

	private User originator;
	private List<User> recipients;
	
	private String message;
	
	public User getOriginator() {
		return originator;
	}

	public void setOriginator(User originator) {
		this.originator = originator;
	}
	
	public List<User> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<User> recipients) {
		this.recipients = recipients;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public PacketType type() {
		return PacketType.MESSAGE;
	}

}
