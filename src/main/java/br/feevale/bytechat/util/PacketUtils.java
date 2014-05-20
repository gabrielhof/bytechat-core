package br.feevale.bytechat.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.feevale.bytechat.packet.File;

public final class PacketUtils {
	
	private static final int FILE_SPLIT_SIZE = (1024 * 1024 * 5); //2MB
	
	public static void sendSerializedFile(Session session, java.io.File file) {
		try {
			long fileLength = file.length();
			int totalParts = new BigDecimal(fileLength).divide(new BigDecimal(FILE_SPLIT_SIZE), RoundingMode.CEILING).intValue();
			
			File f = new File();
			f.setFileId(generateId(file.getAbsolutePath()));
			f.setName(file.getName());
			f.setContentType(Files.probeContentType(Paths.get(file.getAbsolutePath())));
			f.setTotalParts(totalParts);
			
			InputStream input = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[fileLength > FILE_SPLIT_SIZE ? FILE_SPLIT_SIZE : (int) fileLength];
			long alreadyRead = 0;
			for (int i = 1, readed; (readed = input.read(buffer)) > -1; i++) {
				alreadyRead += readed;
				
				f.setPart(i);
				f.setContents(buffer);
					
				session.send(f);
				
				long missing = fileLength - alreadyRead;
				
				if (missing < FILE_SPLIT_SIZE) {
					buffer = new byte[missing == 0 ? 1 : (int) missing];
				}
				
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
