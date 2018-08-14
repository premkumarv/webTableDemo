package com.w2a.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.w2a.testBase.testBase;

public class tableCheck extends testBase{

	
	@Test(priority=1)
	public void formInput() throws InterruptedException{
		
		
		driver.findElement(By.xpath(OR.getProperty("addUserBtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("firstNameTxt"))).sendKeys("PREM");
		driver.findElement(By.xpath(OR.getProperty("lastNameTxt"))).sendKeys("Kumar");
		driver.findElement(By.xpath(OR.getProperty("userNameTxt"))).sendKeys("PREM KUMAR");
		driver.findElement(By.xpath(OR.getProperty("passwordTxt"))).sendKeys("PREM KUMAR");
		driver.findElement(By.xpath(OR.getProperty("customerRadio"))).click();
		
		Select role = new Select(driver.findElement(By.xpath(OR.getProperty("roleSelect"))));
		role.selectByValue("0");
		
		driver.findElement(By.xpath(OR.getProperty("emailTxt"))).sendKeys("premece66@yahoo.co.in");
		driver.findElement(By.xpath(OR.getProperty("cellTxt"))).sendKeys("9710699578");
		driver.findElement(By.xpath(OR.getProperty("saveBtn"))).click();


		Thread.sleep(4000);
        
		
		


		

	}
	
	
	
}
