package com.crm.comcast.objectrepositoryUtility;
/**
 * 
 * @author Deepak
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class Home extends WebDriverUtility{
	WebDriver driver;
	
	public Home(WebDriver driver){
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLnk;
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}
	
	/**
	 * used to logout from the application
	 * @throws Throwable 
	 */
	public void logout() throws Throwable {
		waitAndClick(adminImg);
		//moveToExpectedElemnet(driver, adminImg);
		signOutLnk.click();
	}
	

}
