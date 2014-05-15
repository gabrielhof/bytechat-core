package br.feevale.bytechat.exception;

public class ConnectionException extends ChatException {

	private static final long serialVersionUID = 8086270641343370057L;

	public ConnectionException(String message) {
		super(message);
	}
	
	public ConnectionException(Throwable cause) {
		super(cause);
	}
	
	public ConnectionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
