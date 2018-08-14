package com.w2a.TestCase;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.w2a.util.ExcelReader;
import com.w2a.testBase.testBase;

import com.w2a.util.*;

public class tableCheck extends testBase{

	public static ExcelReader excel = new ExcelReader("C:\\Users\\PREAM\\workspace\\webTableDemo\\src\\test\\resources\\excel\\TestData.xlsx");
	
	
	@Test(dataProvider ="getData") 
	public  void addEmpDetails(String firstName,String  lastName, String userName, String password,String values,String roles,String email, String cell) {
		
		
		driver.findElement(By.xpath(OR.getProperty("addUserBtn"))).click();
		 
		driver.findElement(By.xpath(OR.getProperty("firstNameTxt"))).clear();
		driver.findElement(By.xpath(OR.getProperty("lastNameTxt"))).clear();
		driver.findElement(By.xpath(OR.getProperty("userNameTxt"))).clear();;
		driver.findElement(By.xpath(OR.getProperty("passwordTxt"))).clear();
		driver.findElement(By.xpath(OR.getProperty("emailTxt"))).clear();
		driver.findElement(By.xpath(OR.getProperty("cellTxt"))).clear();
		
		
		driver.findElement(By.xpath(OR.getProperty("firstNameTxt"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lastNameTxt"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("userNameTxt"))).sendKeys(userName);
		driver.findElement(By.xpath(OR.getProperty("passwordTxt"))).sendKeys(password);
		
		
	  // radio button	
	List<WebElement> select = driver.findElements(By.name("optionsRadios"));

	for (WebElement radio : select){
		
	if (radio.getAttribute("value").equalsIgnoreCase(values))
	radio.click();
	}	
	
	
	
	
		
		Select role = new Select(driver.findElement(By.xpath(OR.getProperty("roleSelect"))));
		role.selectByVisibleText(roles);
		
		driver.findElement(By.xpath(OR.getProperty("emailTxt"))).sendKeys(email);
		driver.findElement(By.xpath(OR.getProperty("cellTxt"))).sendKeys(cell);
		//driver.switchTo().alert().accept();
		driver.findElement(By.xpath(OR.getProperty("saveBtn"))).click();
		
		
		
        }
	
	@DataProvider
	public Object [][] getData(){
		
		String sheetName ="addEmpDetails";
		 int rows =excel.getRowCount(sheetName);
		 int cols =excel.getColumnCount(sheetName);
		 
		 Object [][] data  = new Object[rows-1][cols];
		 for (int rowNum =2; rowNum<=rows; rowNum++){
			 for(int colNum=0; colNum<cols; colNum++){
				 data[rowNum-2][colNum]=excel.getCellData(sheetName,colNum,rowNum);
			 }
			 
			 
			 
		 }
		 
		return data ;
		
	}
	
	
	
}
