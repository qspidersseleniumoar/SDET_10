package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MMTBookTicket {
	@Test
	public void calenderWinDowTest() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		 driver.get("https://www.makemytrip.com/flights");
		 
		 Actions act = new Actions(driver);
		 act.moveByOffset(10, 10).click().perform();
		 
		 Thread.sleep(1000);
		 //click on Calender Window , & enable the POPUP
		 driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
        int count = 0;
		 while (count < 11) {
			
				 try {
				    //click on expected Date
				    String x = "//div[@aria-label='Sat Feb 30 2021']/div/p[text()='25']";
				    driver.findElement(By.xpath(x)).click();
				    System.out.println("given date is valid");
				    break;
				 }catch (Exception e) {
					 //click on next month button
					 driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
					 count++;
				}
		 
		 }
		 
		 if(count==11) {
			 System.out.println("given date in invalid");
		 }
	}

}
