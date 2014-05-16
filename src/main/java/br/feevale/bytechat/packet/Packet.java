package br.feevale.bytechat.packet;

import java.io.Serializable;


public interface Packet extends Serializable {

	public PacketType getType();
	
}
