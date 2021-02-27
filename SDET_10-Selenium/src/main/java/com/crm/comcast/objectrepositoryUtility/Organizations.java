package com.crm.comcast.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	WebDriver driver;
	
	public Organizations(WebDriver driver){
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "search_text")
	private WebElement serchEdt;
	
	@FindBy(name = "search")
	private WebElement serchBtn;
	
	
	public WebElement getSerchEdt() {
		return serchEdt;
	}

	public WebElement getSerchBtn() {
		return serchBtn;
	}


	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgImg;

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	
	
}
