package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DynnmicWebtable {
	
	
	@Test
	public void captureDynamicWentable() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MICROSECONDS);
		
		driver.get("http://localhost:8888");
          //login
		  driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("admin");
		  driver.findElement(By.id("submitButton")).click();
		  
		  //navigate to Organizations Page
		  driver.findElement(By.linkText("Organizations")).click();
		  
		  //capture all the Organization name from 2 rd Column
		  String x = "//table[@class='lvt small']/tbody/tr[*]/td[3]/a";
		  List<WebElement> lst = driver.findElements(By.xpath(x));
		  
		  for(WebElement wb : lst) {
			  System.out.println(wb.getText());
		  }
		  
		  
	}

}
