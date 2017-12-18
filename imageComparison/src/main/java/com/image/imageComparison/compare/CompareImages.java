package com.image.imageComparison.compare;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.image.imageComparison.webdriver.Driver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class CompareImages {
	
	public static void captureImageInChrome(String urlKey){
		//loadURLs(getURLFile(),System.getProperty("mode"));
		String url = getURLFromFile(urlKey);
		prepareScreen(url,urlKey);
	}
	
	private static String getURLFromFile(String urlKey){
		File f = new File("./src/main/resources/appUrls.properties");
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("./src/main/resources/appUrls.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			
			return prop.getProperty(urlKey);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	private static void prepareScreen(String url,String urlKey){
		ChromeDriver driver = Driver.getInstance();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	populateScreenFields(urlKey,driver,System.getProperty("mode"));
	}
	/*public static void invokeImageComaparison(File file,String mode){
		loadURLs(file,mode);
	}

public static void loadURLs(File file,String mode){
		
		ChromeDriver driver = Driver.getInstance();
		driver.manage().window().maximize();
		FileInputStream fis;
		Scanner scanner = null;
		try {
			fis = new FileInputStream(file);
		
        scanner = new Scanner(fis);
        scanner.useDelimiter(System.getProperty("line.separator"));
        System.out.println("Reading file line by line in Java using Scanner");
        while (scanner.hasNext()) {
        	System.out.println("111");
        	String[] keyValue = scanner.next().split("=");
        	driver.get(keyValue[1]);
        	populateScreenFields(keyValue[0],driver,mode);
    		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        }
        
       
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			scanner.close();
		}

		//driver.close();
		
	}
*/
	public static void populateScreenFields(String screenName, ChromeDriver driver, String mode) {
		Scanner scanner1;
		try {
			File propFile = new File("./src/main/resources/" + mode + "/" + screenName + ".properties");
			if(propFile.exists()){
				scanner1 = new Scanner(propFile);

				scanner1.useDelimiter(System.getProperty("line.separator"));
				while (scanner1.hasNext()) {
					String[] kv = scanner1.next().split("=");
					System.out.println(kv[0]);
					WebElement elem = driver.findElement(By.name(kv[0]));
					//System.out.println("elem"+elem.getAttribute("type"));
					if(elem.getAttribute("type").equalsIgnoreCase("submit")){
						System.out.println("453656358734");
						elem.click();
					}else{
						elem.sendKeys(kv[1]);
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("sdajgdfashdghagsdkasjkdhasjdhjashdjkasdhkhasjkdhjashdj");
		}
		driver.findElement(By.tagName("body")).sendKeys("\n");
		takeScreenShotAndSaveAs(driver,screenName,mode);
		//driver.quit();
	}
	public static void quitDriver(){
		Driver.getInstance().close();
	}
	public static void takeScreenShotAndSaveAs(ChromeDriver driver,String screenName,String mode) {
				
		final Screenshot screenshot = new AShot().shootingStrategy(
                new ViewportPastingStrategy(1500)).takeScreenshot(driver);
       BufferedImage image = screenshot.getImage();
        //image =(BufferedImage)image.getScaledInstance(1040, 1668, Image.SCALE_SMOOTH);
        BufferedImage image1 =
        	     Scalr.resize(image, Scalr.Method.BALANCED, 1040, 1668);
        try {
        	File direc = new File("./src/screenCapture/"+mode);
        	if(!direc.exists()){
        		direc.mkdir();
        	}
			ImageIO.write(image1, "PNG", new File("./src/screenCapture/"+mode+"/"+screenName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String compareImage(String urlKey)  {
		if("Actual".equalsIgnoreCase(System.getProperty("mode"))){
			//HashSet<String> imageWithDiff = new HashSet<String>();
			String imageWithDiff ="";
			boolean isSame = true;
			//Scanner scanner1;
			
				//scanner1 = new Scanner(file);

				//scanner1.useDelimiter(System.getProperty("line.separator"));
				//while (scanner1.hasNext()) {
					 List<Family> families = new ArrayList<Family>();
					//String[] kv = scanner1.next().split("=");
					try {
						//String imageFolder = Configuration.getConfig(Configuration.ConfigurationKeys.IMAGE_FOLDER.getKey());
						BufferedImage expected = ImageIO.read(new File("./src/screenCapture/Expected/"+urlKey+".png"));
						
						BufferedImage actual = ImageIO.read(new File("./src/screenCapture/Actual/"+urlKey+".png"));
						Graphics2D g2d = actual.createGraphics();
						g2d.setColor(Color.RED);
						g2d.setStroke(new BasicStroke(2));
						for(int i=0; i< expected.getWidth();i++){
							for(int j=0; j< expected.getHeight();j++){
								Color colExpected = new Color(expected.getRGB(i, j));
								Color colActual = new Color(actual.getRGB(i, j));
								 isSame = isSame(expected, actual, colExpected, colActual);
								if(!isSame){
									imageWithDiff = urlKey+".png";
									putIntoFamily(i, j,families);
								}
							
							}
						}
						//System.out.println(families);
						for(Family family:families){
							
							g2d.drawRect(family.getMinX()-2, family.getMinY()-2, family.getMaxX()-family.getMinX()+2, family.getMaxY()-family.getMinY()+2);
						}
						
						File direc = new File("./src/screenCapture/Difference/");
				    	if(!direc.exists()){
				    		direc.mkdir();
				    	}
				    	if(!imageWithDiff.equalsIgnoreCase("")){
				    		ImageIO.write(actual,"PNG",new File("./src/screenCapture/Difference/"+urlKey+"-Difference.png"));
				    	}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//}
			
			
			return imageWithDiff; 
		}
		return null;
	}
	
	private static void putIntoFamily(int x, int y,List<Family> families) {
		boolean familyFound = false;
		for(Family family: families){
			if(family.isMember(x, y)){
				family.reset(x, y);
				familyFound = true;
				break;
			}
		}
		if(!familyFound){
			families.add(new Family(x,y,x,y));
		}
		
		
	}

	private static boolean isSame(BufferedImage expected, BufferedImage actual,
			Color colExpected, Color colActual) {
		

		return colExpected.getRed()==colActual.getRed() && colExpected.getGreen()==colActual.getGreen() && colExpected.getBlue()==colActual.getBlue();
	}
}
