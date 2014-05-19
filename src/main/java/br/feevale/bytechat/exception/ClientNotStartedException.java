package br.feevale.bytechat.exception;

public class ClientNotStartedException extends ClientException {

	private static final long serialVersionUID = -2454435554935408577L;

	public ClientNotStartedException(String message) {
		super(message);
	}
	
}
