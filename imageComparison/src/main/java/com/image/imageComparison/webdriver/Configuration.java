package com.image.imageComparison.webdriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	public static enum ConfigurationKeys {
		IMAGE_FOLDER("ImageFolder"), DRIVER_EXE_PATH("DriverExePath");
		
		private String key;
		ConfigurationKeys(String key){
			this.key = key;
		}
		public String getKey() {
			return key;
		}
		
	}
	
	private static Configuration uniqInstance = new Configuration();
	private Properties props;
	
	private Configuration() {
		props = new Properties();
		try {
			props.load(new FileReader("./src/main/resources/config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	
	
	public static String getConfig(String configKey){
		return (String) uniqInstance.props.get(configKey);
	}
	
	
}
