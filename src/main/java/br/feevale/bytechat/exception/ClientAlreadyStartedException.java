package br.feevale.bytechat.exception;


public class ClientAlreadyStartedException extends ClientException {

	private static final long serialVersionUID = -6021772589334291166L;

	public ClientAlreadyStartedException(String message) {
		super(message);
	}
	
}
