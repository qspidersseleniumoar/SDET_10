package com.practice;

import java.util.concurrent.TimeUnit;

import javax.crypto.KeyAgreementSpi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;

public class DataDriventest {
	
	@Test(dataProvider =  "getData")
	public void bookTicketTest(String src , String dst) {
         
		 ExcelUtility excel = new ExcelUtility();
		 
		 WebDriver driver = new FirefoxDriver(); 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://www.makemytrip.com/flights");
		  
		  
			 Actions act = new Actions(driver);
			 act.moveByOffset(10, 10).click().perform();
			 
			 
		  driver.findElement(By.xpath("//span[text()='From']")).click();
		  driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(src);
		  driver.findElement(By.xpath("//div[text()='"+src+"']")).click();
		  
		  driver.findElement(By.xpath("//span[text()='To']")).click();
		  driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(dst);
		  driver.findElement(By.xpath("//div[text()='"+dst+"']")).click();
        
		  driver.close();
		  
	
		  
		
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable {

		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "BLR";
		objArr[0][1] = "GOI";
		
		objArr[1][0] = "PUT";
		objArr[1][1] = "GOI";
		
		objArr[2][0] = "SXV";
		objArr[2][1] = "GOI";
		return objArr;		
	}

}
