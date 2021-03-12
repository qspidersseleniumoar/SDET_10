package com.crm.comcast.genericutility;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.events.EventHandler;
import com.crm.comcast.objectrepositoryUtility.Home;
import com.crm.comcast.objectrepositoryUtility.Login;

public class BaseClass {
	/*Object creation*/
	public FileUtility fLib = new FileUtility();
	public ExcelUtility excel = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public DataBaseUtilities dbLb = new DataBaseUtilities();
	public WebDriver driverRef;
	public EventFiringWebDriver driver;
	public static WebDriver staticDriver;
	public Logger logger;
	
	@BeforeSuite(groups = {"smokeTest" , "regressionTest"})
	public void configBeforeSuite() throws Throwable {
		System.out.println("==============Connect to DB=============");
		dbLb.connectToDB();
		
	}
	
	@BeforeClass(groups = {"smokeTest" , "regressionTest"})
	public void configBeforeClass() throws Throwable {
		System.out.println("============launch the Browser==========");
		/* launch the Browser*/
		/*read Common Data*/
		String URL = fLib.getPropertyKeyValue("url");

		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		 if(BROWSER.equals("firefox")) {
		    driverRef = new FirefoxDriver();
		 }else if(BROWSER.equals("chrome")) {
			 driverRef = new ChromeDriver();
		 }else if(BROWSER.equals("ie")) {
			 driverRef = new InternetExplorerDriver();
		 }else {
			 driverRef = new ChromeDriver();
		 }
		 driver=new EventFiringWebDriver(driverRef);
		 EventHandler event=new EventHandler();
		 driver.register(event);
		staticDriver= driver;
		 wlib.waitForPageToLoad(driver);
		 driver.get(URL);
		
	}
	
	@Parameters("BROWSER")
	//@BeforeClass(groups = {"smokeTest" , "regressionTest"})
	public void configBeforeClassParllel(String Browser) throws Throwable {
		System.out.println("============launch the Browser==========");
		/* launch the Browser*/
		/*read Common Data*/
		String URL = fLib.getPropertyKeyValue("url");

		
		
		 if(Browser.equals("firefox")) {
		    //driver = new FirefoxDriver();
		 }else if(Browser.equals("chrome")) {
			// driver = new ChromeDriver();
		 }else if(Browser.equals("ie")) {
			// driver = new InternetExplorerDriver();
		 }else {
			// driver = new ChromeDriver();
		 }
		
		 wlib.waitForPageToLoad(driver);
		 driver.get(URL);
	}
	
	
	@BeforeMethod(groups = {"smokeTest" , "regressionTest"})
	public void configBeforeMtd() throws Throwable {
		System.out.println("====login to Application=====");
		/*step-1 : login to Application*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		Login lp = new Login(driver);
		lp.loginToAPP(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups = {"smokeTest" , "regressionTest"})
	public void configAfterMethod() throws Throwable {
		System.out.println("====logout from Application=====");
		Home hp = new Home(driver);
	      /*step-* : logout */
			  hp.logout();
			  Login lp = new Login(driver);
			  wlib.waitForElemnetVisibality(driver,lp.getLoginBtn());      
    }
	
	
	@AfterClass(groups = {"smokeTest" , "regressionTest"})
	public void configAfterClass() {
		System.out.println("============Close the Browser==========");
		driver.close();
	}
	
	@AfterSuite(groups = {"smokeTest" , "regressionTest"})
	public void configAfterSuite() throws Throwable {
		dbLb.closeDb();
		System.out.println("==============close db Connection=============");
	}

}
