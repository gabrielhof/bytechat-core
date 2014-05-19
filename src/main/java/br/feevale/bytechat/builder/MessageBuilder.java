package br.feevale.bytechat.builder;

import java.util.ArrayList;
import java.util.List;

import br.feevale.bytechat.packet.Message;
import br.feevale.bytechat.util.User;

public class MessageBuilder {

	private Message message = new Message();
	
	private MessageBuilder() {}
	
	public MessageBuilder from(User originator) {
		message.setOriginator(originator);
		return this;
	}
	
	public MessageBuilder to(List<User> recipients) {
		message.setRecipients(recipients);
		return this;
	}
	
	public MessageBuilder to(User recipient) {
		if (message.getRecipients() == null) {
			message.setRecipients(new ArrayList<User>());
		}
		
		message.getRecipients().add(recipient);
		return this;
	}
	
	public MessageBuilder withMessage(String m) {
		message.setMessage(m);
		return this;
	}
	
	public Message getMessage() {
		return message;
	}
	
	public static MessageBuilder create() {
		return new MessageBuilder();
	}
	
}
