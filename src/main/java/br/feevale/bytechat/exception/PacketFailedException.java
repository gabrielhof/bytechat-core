package br.feevale.bytechat.exception;

import br.feevale.bytechat.packet.Fail;

public class PacketFailedException extends ClientException {

	private static final long serialVersionUID = -2171912701555970525L;
	
	private Fail fail;
	
	public PacketFailedException(Fail fail) {
		super(String.format("Falha ao estabelecer conxão com o servidor: %s", fail.getFailType().toString()));
		this.fail = fail;
	}
	
	public Fail getFail() {
		return fail;
	}

}
