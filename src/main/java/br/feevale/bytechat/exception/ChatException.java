package br.feevale.bytechat.exception;

public class ChatException extends Exception {

	private static final long serialVersionUID = 798077189392515644L;

	public ChatException() {
		super();
	}
	
	public ChatException(String message) {
		super(message);
	}
	
	public ChatException(String message, Throwable cause) {
		 super(message, cause);
	}
	
	public ChatException(Throwable cause) {
		super(cause);
	}
	
}
