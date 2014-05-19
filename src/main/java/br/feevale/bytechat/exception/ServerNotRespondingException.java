package br.feevale.bytechat.exception;

public class ServerNotRespondingException extends ClientException {

	private static final long serialVersionUID = -7341232165564834847L;

	public ServerNotRespondingException(String message) {
		super(message);
	}
	
	public ServerNotRespondingException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
