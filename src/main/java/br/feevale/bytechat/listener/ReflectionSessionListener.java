package br.feevale.bytechat.listener;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;

import br.feevale.bytechat.packet.Packet;
import br.feevale.bytechat.util.ReflectionUtils;
import br.feevale.bytechat.util.Session;

public abstract class ReflectionSessionListener implements SessionListener {

	private static final String METHOD_SUFFIX = "Received";
	
	@Override
	public void packetReceived(Session source, Packet packet) {
		try {
			String methodName = packet.getClass().getSimpleName();
			methodName = StringUtils.uncapitalize(methodName) + METHOD_SUFFIX;

			Method method = ReflectionUtils.findMethod(this.getClass(), methodName, Session.class, packet.getClass());
			if (method != null) {
				method.invoke(this, source, packet);
			} else {
				method = ReflectionUtils.findMethod(this.getClass(), methodName, packet.getClass(), Session.class);
				
				if (method != null) {
					method.invoke(this, packet, source);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
