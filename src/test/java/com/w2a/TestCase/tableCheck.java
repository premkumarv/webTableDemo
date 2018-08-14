package com.w2a.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.w2a.util.ExcelReader;
import com.w2a.testBase.testBase;

import com.w2a.util.*;

public class tableCheck extends testBase{

	public static ExcelReader excel = new ExcelReader("C:\\Users\\PREAM\\workspace\\webTableDemo\\src\\test\\resources\\excel\\TestData.xlsx");
	
	
	@Test(dataProvider ="getData") 
	public void formInput(String firstName,String  lastName, String userName, String password,String email, String cell) {
		
		
		driver.findElement(By.xpath(OR.getProperty("addUserBtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("firstNameTxt"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lastNameTxt"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("userNameTxt"))).sendKeys(userName);
		driver.findElement(By.xpath(OR.getProperty("passwordTxt"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("customerRadio"))).click();
		
		Select role = new Select(driver.findElement(By.xpath(OR.getProperty("roleSelect"))));
		role.selectByValue("0");
		
		driver.findElement(By.xpath(OR.getProperty("emailTxt"))).sendKeys(email);
		driver.findElement(By.xpath(OR.getProperty("cellTxt"))).sendKeys(cell);
		//driver.switchTo().alert().accept();
		driver.findElement(By.xpath(OR.getProperty("saveBtn"))).click();
		//driver.findElement(By.xpath(OR.getProperty("addUserBtn"))).click();

		//Thread.sleep(4000);
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
