package br.feevale.bytechat.protocol;

import java.io.IOException;
import java.io.StringWriter;

import br.feevale.bytechat.packet.Packet;
import br.feevale.bytechat.packet.PacketType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JsonPacketTransformer implements PacketTransformer {

	private ObjectMapper jsonMapper;
	
	public JsonPacketTransformer() {
		jsonMapper = new ObjectMapper();
		jsonMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
		jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		jsonMapper.registerModule(new PacketModule());
	}
	
	@Override
	public Packet fromString(String s) {
		try {
			Packet packet = jsonMapper.readValue(s, Packet.class);
			return jsonMapper.readValue(s, packet.getType().getPacketClass());
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
	
	class PacketModule extends SimpleModule {

		private static final long serialVersionUID = 8069029095633057808L;
		
		public PacketModule() {
			addDeserializer(Packet.class, new PacketDeserializer());
		}
	}
	
	class PacketDeserializer extends JsonDeserializer<Packet> {

		@Override
		public Packet deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
			JsonNode node = jp.readValueAsTree();
			JsonNode typeNode = node.get("type");
			
			PacketType type = PacketType.valueOf(typeNode.asText());
			try {
				FakePacket packet = new FakePacket();
				packet.setType(type);
				
				return packet;
			} catch (Exception e) {
				throw new JsonParseException("Pacote declarado incorretamente.", jp.getCurrentLocation());
			}
		}
		
	}
	
	class FakePacket implements Packet {

		private static final long serialVersionUID = -4390875428206475490L;
		
		private PacketType type;
		
		public void setType(PacketType type) {
			this.type = type;
		}
		
		@Override
		public PacketType getType() {
			return type;
		}
		
	}
}
