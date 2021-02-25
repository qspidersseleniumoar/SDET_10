package com.crm.comcast.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Login {
	 public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 
	 
	 @FindBys({@FindBy(id = "submitButton") , @FindBy(xpath = "//input[@type='submit']")})
	 private WebElement loginBtn;
	 
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;


	
	public void loginToAPP(String username , String password) {
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	public void loginToAPP() {
		userNameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		loginBtn.click();
	}

}
