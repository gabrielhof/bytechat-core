package br.feevale.bytechat.server.connector;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import br.feevale.bytechat.exception.ConnectionException;
import br.feevale.bytechat.exception.PacketException;
import br.feevale.bytechat.packet.Packet;

public interface Connection {

	public BufferedReader getReader();
	
	public BufferedWriter getWriter();
	
	public void send(Packet packet) throws PacketException;
	
	public Packet receive() throws PacketException;
	
	public void close() throws ConnectionException;
	
	public boolean isClosed();
}
