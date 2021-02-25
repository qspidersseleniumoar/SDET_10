package com.practice;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Calender_CurrentData {
	@Test
	public void calenderWinDowTest() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		 driver.get("https://www.makemytrip.com/flights");
		  Actions act = new Actions(driver);
		 act.moveByOffset(10, 10).click().perform();
		
		 //click on Calender Window , & enable the POPUP
		 driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		 
			Date dateObj = new Date();
			 String strDate =  dateObj.toString();
			 String[] arr = strDate.split(" ");
			 String year = arr[5];
			 String month = arr[1];
			 String date = arr[2];

		    String x = "//div[contains(@aria-label,'"+month+" "+date+" "+year+"')]/div/p[text()='"+date+"']";
		    driver.findElement(By.xpath(x)).click();
	}

}



