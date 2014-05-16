package br.feevale.bytechat.protocol;

import java.io.StringWriter;

import br.feevale.bytechat.packet.FakePacket;
import br.feevale.bytechat.packet.Packet;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonPacketTransformer implements PacketTransformer {

	private ObjectMapper jsonMapper;
	
	public JsonPacketTransformer() {
		jsonMapper = new ObjectMapper();
		jsonMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
		jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	@Override
	public Packet fromString(String s) {
		try {
			FakePacket fake = jsonMapper.readValue(s, FakePacket.class);
			Packet packet = jsonMapper.readValue(s, fake.getType().getPacketClass());
			
			return packet;
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
