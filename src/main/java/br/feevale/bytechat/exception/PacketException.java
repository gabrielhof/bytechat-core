package br.feevale.bytechat.exception;

public class PacketException extends ChatException {

	private static final long serialVersionUID = -3110691045740094716L;

	public PacketException(String message) {
		super(message);
	}
	
	public PacketException(Throwable cause) {
		super(cause);
	}
	
	public PacketException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
