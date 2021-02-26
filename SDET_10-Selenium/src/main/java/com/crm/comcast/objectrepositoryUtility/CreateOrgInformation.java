package com.crm.comcast.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgInformation {
	WebDriver driver;
	
	public CreateOrgInformation(WebDriver driver){
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className = "dvHeaderText")
	private WebElement successfulMsg;

	public WebElement getSuccessfulMsg() {
		return successfulMsg;
	}


	
	
}
