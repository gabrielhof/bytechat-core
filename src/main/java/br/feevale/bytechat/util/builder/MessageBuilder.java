package br.feevale.bytechat.util.builder;

import java.util.ArrayList;
import java.util.List;

import br.feevale.bytechat.util.User;
import br.feevale.bytechat.util.packets.Message;

public class MessageBuilder {

	private Message message = new Message();
	
	private MessageBuilder() {}
	
	public MessageBuilder originator(User originator) {
		message.setOriginator(originator);
		return this;
	}
	
	public MessageBuilder recipients(List<User> recipients) {
		message.setRecipients(recipients);
		return this;
	}
	
	public MessageBuilder recipient(User recipient) {
		if (message.getRecipients() == null) {
			message.setRecipients(new ArrayList<User>());
		}
		
		message.getRecipients().add(recipient);
		return this;
	}
	
	public MessageBuilder message(String m) {
		message.setMessage(m);
		return this;
	}
	
	public static MessageBuilder create() {
		return new MessageBuilder();
	}
	
}
