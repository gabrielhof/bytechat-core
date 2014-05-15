package br.feevale.bytechat.exception;


public class ServerException extends ChatException {

	private static final long serialVersionUID = -196792134103936579L;

	public ServerException() {
		super();
	}
	
	public ServerException(String message) {
		super(message);
	}
	
	public ServerException(String message, Throwable cause) {
		 super(message, cause);
	}
	
	public ServerException(Throwable cause) {
		super(cause);
	}
}
