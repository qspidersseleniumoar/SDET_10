package com.crm.comcast.organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.objectrepositoryUtility.Login;
/**
 * 
 * @author Deepak
 *
 */
public class OrganizationTest {

	
	 
	
	@Test
	public void createOrganizationTest() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888");
		
	
		Login lp = new Login();
		lp.loginToAPP();
		
		

		
	}
}





