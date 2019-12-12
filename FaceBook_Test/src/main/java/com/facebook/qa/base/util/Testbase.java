package com.facebook.qa.base.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.facebook.qa.util.Utiltest;

/* initilising all the properties firefox launch,maximize windows,wait etc    */

public class Testbase {
	
	public static WebDriver driver;
    public static Properties prop;
	
	
	
	public Testbase(){
		
		// Reading The properties File.
		
		try{
				prop  = new Properties();
			FileInputStream ip = new FileInputStream("F:\\Selennium\\FaceBook_Test\\src\\main\\java\\com\\facebook\\qa\\config\\config.properties");
		      
			//Load all properties inside Config.Properties
			
			prop.load(ip); 
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialisation(){
		String browserName =prop.getProperty("browser");
		
		if(browserName.equals("firefox")){
			
			System.getProperty("webdriver.gecko.driver","F:\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utiltest.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utiltest.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
