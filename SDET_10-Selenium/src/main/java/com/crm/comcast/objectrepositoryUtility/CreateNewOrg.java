package com.crm.comcast.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;
/**
 * 
 * @author Deepak
 *
 */
public class CreateNewOrg extends WebDriverUtility{
	WebDriver driver;
	
	public CreateNewOrg(WebDriver driver){
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryLst;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	/**
	 *  used to cerate OrgName with mandatory info
	 * @param orgName
	 */
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveButton.click();
	}
	
	/**
	 *  used to cerate OrgName with industry type
	 * @param orgName
	 */
	public void createOrg(String orgName , String industry) {
		orgNameEdt.sendKeys(orgName);
		select(industryLst, industry);
		saveButton.click();
	}
	
}
