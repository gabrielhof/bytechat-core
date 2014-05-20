package br.feevale.bytechat.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.feevale.bytechat.packet.File;

public final class PacketUtils {
	
	private static final int FILE_SPLIT_SIZE = (1024 * 1024 * 2); //2MB
	
	public static void sendSerializedFile(Session session, java.io.File file) {
		try {
			int totalParts = new BigDecimal(file.length()).divide(new BigDecimal(FILE_SPLIT_SIZE), RoundingMode.CEILING).intValue();
			
			File f = new File();
			f.setFileId(generateId(file.getAbsolutePath()));
			f.setName(file.getName());
			f.setContentType(Files.probeContentType(Paths.get(file.getAbsolutePath())));
			f.setTotalParts(totalParts);
			
			InputStream input = new FileInputStream(file);
			byte[] buffer = new byte[FILE_SPLIT_SIZE];
			for (int i = 1; input.read(buffer) > -1; i++) {
				f.setPart(i);
				f.setContents(buffer);
				
				session.send(f);
			}
			
			input.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String generateId(Object object) {
		return String.valueOf(object.hashCode()) + String.valueOf(10000 * Math.random());
	}

}
