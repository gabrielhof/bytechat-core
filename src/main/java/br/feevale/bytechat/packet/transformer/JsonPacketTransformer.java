package br.feevale.bytechat.packet.transformer;

import java.io.StringWriter;

import br.feevale.bytechat.packet.Packet;
import br.feevale.bytechat.packet.impl.Message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JsonPacketTransformer implements PacketTransformer {

	private ObjectMapper jsonMapper;
	
	public JsonPacketTransformer() {
		jsonMapper = new ObjectMapper();
		jsonMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
	}
	
	@Override
	public Packet fromString(String s) {
		try {
			Message message = jsonMapper.readValue(s, Message.class); //TODO generalizar
			
			return message;
		} catch (Exception e) {
			//TODO implementar algo
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String transform(Packet packet) {
		try {
			StringWriter cache = new StringWriter();

			jsonMapper.writeValue(cache, packet);
			String result = cache.toString();
			
			cache.close();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
