package br.feevale.bytechat.config;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class Configuration {

	private String host;
	private int port;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public static Configuration fromProperties() {
		try {
			Properties properties = new Properties();
			properties.load(Configuration.class.getClassLoader().getResourceAsStream("settings.properties"));
			
			Configuration config = new Configuration();
			config.setHost(properties.getProperty("server.host", "localhost"));
			config.setPort(Integer.parseInt(properties.getProperty("server.port", "8080")));
			
			String hostEnv = System.getenv("CHAT_SERVER_HOST");
			String portEnv = System.getenv("CHAT_SERVER_PORT");
			
			if (StringUtils.isNotBlank(hostEnv)) {
				config.setHost(hostEnv);
			}
			
			if (StringUtils.isNotBlank(portEnv)) {
				config.setPort(Integer.parseInt(portEnv));
			}
			
			return config;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
