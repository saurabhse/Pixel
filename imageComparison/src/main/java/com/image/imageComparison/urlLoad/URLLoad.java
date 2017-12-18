package com.image.imageComparison.urlLoad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.image.imageComparison.webdriver.Driver;

public class URLLoad {
	
	public static void loadURLs(File file,String mode){
		
		try {
            final Scanner scanner = new Scanner(file);
            scanner.useDelimiter(System.getProperty("line.separator"));
            while (scanner.hasNext()) {
                String[] keyValue = scanner.next().split("=");
                System.out.println(keyValue[0] + keyValue[1]);
                // keyValue[0] is the key
                // keyValue[1] is the value
                // do something with them
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		System.out.println("**********************");
		
		ChromeDriver driver = Driver.getInstance();
		driver.manage().window().maximize();
		FileInputStream fis;
		Scanner scanner = null;
		try {
			fis = new FileInputStream(file);
		
        scanner = new Scanner(fis);
        scanner.useDelimiter(System.getProperty("line.separator"));
        System.out.println("Reading file line by line in Java using Scanner");
        List<WebElement> el = new ArrayList<WebElement>();
        while (scanner.hasNext()) {
        	System.out.println("111");
        	String[] keyValue = scanner.next().split("=");
        	driver.get(keyValue[1]);
        	Scanner scanner1 = new Scanner(new File("./src/main/resources/"+mode+"/"+keyValue[0]+".properties"));
        	scanner1.useDelimiter(System.getProperty("line.separator"));
        	while (scanner1.hasNext()) {
        		String[] kv = scanner1.next().split("=");
        		WebElement elem = driver.findElement(By.name(kv[0]));
        		elem.sendKeys(kv[1]);
        	}
    		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	/*WebElement ef = driver.findElement(By.name("firstName"));
        	System.out.println("tag "+ef.getTagName());
        	el = driver.findElements(By.name("*"));
        	System.out.println("size "+el.size());
        	 for ( WebElement e : el ) {
           	  System.out.println(e.getTagName());
           	}*/
        	//((JavascriptExecutor) driver).executeScript("var g = document.querySelectorAll('form > [name]');alert('hello world'+g[0].getAttribute('name'));");
        }
        
       
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			scanner.close();
		}


		
	}

}
