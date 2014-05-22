package br.feevale.bytechat.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public final class FileUtils {

	public static File moveToUserDir(File file, String prettyName) {
		String userDir = System.getProperty("user.home");
		
		if (!userDir.endsWith(java.io.File.separator)) {
			userDir += java.io.File.separator;
		}
		
		java.io.File destination = null;
		
		String[] possibilities = new String[] {"Downloads", "downloads", ""};
		for (String possibility : possibilities) {
			destination = new java.io.File(userDir + possibility);
			if (destination.exists() && destination.isDirectory()) {
				break;
			}
			
			destination = null;
		}
		
		if (destination != null) {
			destination = new java.io.File(destination.getAbsolutePath() + java.io.File.separator + prettyName);
			if (destination.exists()) {
				destination.delete();
			}
			
			if (!file.renameTo(destination)) {
				destination = file;
			}
		} else {
			destination = file;
		}
		
		return destination;
	}

	public static String getContents(String file, boolean classpath) {
		try {
			BufferedReader reader = null;
			
			if (classpath) {
				reader = new BufferedReader(new InputStreamReader(FileUtils.class.getClassLoader().getResourceAsStream(file)));
			} else {
				reader = new BufferedReader(new FileReader(new File(file)));
			}
			
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line).append("\n");
			}
			
			if (!classpath) {
				reader.close();
			}
			
			return builder.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
