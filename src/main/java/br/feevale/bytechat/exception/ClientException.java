package br.feevale.bytechat.exception;

public class ClientException extends ChatException {

	private static final long serialVersionUID = 3563205009407071984L;

	public ClientException() {
		super();
	}
	
	public ClientException(String message) {
		super(message);
	}
	
	public ClientException(String message, Throwable cause) {
		 super(message, cause);
	}
	
	public ClientException(Throwable cause) {
		super(cause);
	}
	
}
