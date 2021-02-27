package com.crm.comcast.objectrepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateNewContact extends WebDriverUtility{
	WebDriver driver;
	
	public CreateNewContact(WebDriver driver){
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement orgLookUPImg;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public void createContact(String lastName) {
		waitForElemnetVisibality(driver, lastNameEdt);
		lastNameEdt.sendKeys(lastName);
		saveButton.click();
	}
	
   public void createContact(String lastName , String orgName) {
	   waitForElemnetVisibality(driver, lastNameEdt);
		lastNameEdt.sendKeys(lastName);
		orgLookUPImg.click();
		switchToBrowser(driver, "module=Accounts");
		
		Organizations org = new Organizations(driver);
		org.getSerchEdt().sendKeys(orgName);
		org.getSerchBtn().click();
		driver.findElement(By.xpath("//a[contains(text(),'"+orgName+"')]")).click();
		
		switchToBrowser(driver, "Contacts");
		saveButton.click();
	}

}
