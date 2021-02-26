package com.crm.comcast.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.objectrepositoryUtility.Home;
import com.crm.comcast.objectrepositoryUtility.Login;

public class BaseClass {
	/*Object creation*/
	public FileUtility fLib = new FileUtility();
	public ExcelUtility excel = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public DataBaseUtilities dbLb = new DataBaseUtilities();
	public WebDriver driver;
	
	@BeforeSuite
	public void configBeforeSuite() throws Throwable {
		dbLb.connectToDB();
	}
	
	@BeforeClass
	public void configBeforeClass() throws Throwable {
		/* launch the Browser*/
		/*read Common Data*/
		String URL = fLib.getPropertyKeyValue("url");

		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		 if(BROWSER.equals("firefox")) {
		    driver = new FirefoxDriver();
		 }else if(BROWSER.equals("chrome")) {
			 driver = new ChromeDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver();
		 }
		
		 wlib.waitForPageToLoad(driver);
		 driver.get(URL);
	}
	
	
	@BeforeMethod
	public void configBeforeMtd() throws Throwable {
		/*step-1 : login to Application*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		Login lp = new Login(driver);
		lp.loginToAPP(USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void configAfterMethod() throws Throwable {
		Home hp = new Home(driver);
	      /*step-* : logout */
			  hp.logout();
    }
	
	
	@AfterClass
	public void configAfterClass() {
		driver.close();
	}
	
	@AfterSuite
	public void configAfterSuite() throws Throwable {
		dbLb.closeDb();
		
	}

}
