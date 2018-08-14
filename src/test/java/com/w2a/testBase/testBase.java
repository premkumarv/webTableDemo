package com.w2a.testBase;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


//import com.gargoylesoftware.htmlunit.javascript.host.Window;

public class testBase {
	public static Properties OR = new Properties();

	public static FileInputStream fis;
	public static WebDriver driver;
	@BeforeSuite
	
	public void startOff() throws IOException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PREAM\\workspace\\webTableDemo\\src\\test\\resources\\executable\\chromedriver.exe");
		
		 fis = new FileInputStream ("C:\\Users\\PREAM\\workspace\\webTableDemo\\src\\test\\resources\\properties\\OR.properties");
		
		OR.load(fis);
		
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		//driver.findElement(By.xpath(OR.getProperty("addUserBtn"))).click();
		
	}
	
	
	
	@AfterSuite
	public void endOff(){
		
		//driver.quit();
		
	}
	
	
}
