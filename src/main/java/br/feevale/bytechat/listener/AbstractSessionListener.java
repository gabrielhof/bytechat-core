package br.feevale.bytechat.listener;

import br.feevale.bytechat.packet.Bind;
import br.feevale.bytechat.packet.Message;
import br.feevale.bytechat.packet.Unbind;
import br.feevale.bytechat.packet.UserList;
import br.feevale.bytechat.util.Session;

public abstract class AbstractSessionListener extends ReflectionSessionListener {
	
	public void bindReceived(Session source, Bind ack) {}
	
	public void unbindReceived(Session source, Unbind unbind) {}
	
	public void messageReceived(Session source, Message message) {}
	
	public void userListReceived(Session source, UserList userList) {}
	
	
	@Override
	public void sessionEnded(Session endedSession) {}

}
