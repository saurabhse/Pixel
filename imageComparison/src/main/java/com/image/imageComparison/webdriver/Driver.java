package com.image.imageComparison.webdriver;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	{//System.out.println("222222"+Configuration.ConfigurationKeys.DRIVER_EXE_PATH.getKey());
	try{
		String driverExePath = Configuration.getConfig(Configuration.ConfigurationKeys.DRIVER_EXE_PATH.getKey());
		
		//System.out.println("1111"+driverExePath);
		File file = new File(driverExePath);
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}catch(Exception e){
		e.printStackTrace();
	}
		
	}
	
	private ChromeDriver chromeDriver = new ChromeDriver();
	
	private static Driver uniqueInstance = new Driver(); 

	public static ChromeDriver getInstance() {
		// TODO Auto-generated method stub
		return uniqueInstance.chromeDriver;
	}
}
