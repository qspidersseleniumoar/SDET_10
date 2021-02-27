package com.crm.comcast.organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.objectrepositoryUtility.CreateNewOrg;
import com.crm.comcast.objectrepositoryUtility.OrgInformation;
import com.crm.comcast.objectrepositoryUtility.Home;
import com.crm.comcast.objectrepositoryUtility.Login;
import com.crm.comcast.objectrepositoryUtility.Organizations;
/**
 * 
 * @author Deepak
 *
 */
public class CreateOrgTest extends BaseClass{

	
	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable {
	
		/* read test Data from Excel */ 
		String orgNAme = excel.getExcelData("Org", "tc_01", "OrgName") +"_" + jLib.getRanDomData();

		
		/*step-2 : navigate to Org Page */
		Home hp = new Home(driver);
		  wlib.waitForElemnetVisibality(driver, hp.getOrgLnk());
		    hp.getOrgLnk().click();
		    
		/*step-3 : navigate to create ORg Page */
		Organizations op = new Organizations(driver);
			 wlib.waitForElemnetVisibality(driver, op.getCreateOrgImg());
		  op.getCreateOrgImg().click();
		  
		/*step-4 : create new ORg Page */
		    CreateNewOrg cno = new CreateNewOrg(driver);
		    cno.createOrg(orgNAme);
		    
		  /*verify Org NAme*/
		    OrgInformation coi = new OrgInformation(driver);
		    wlib.waitForElemnetVisibality(driver, coi.getSuccessfulMsg());
		    String actSusccessMsg = coi.getSuccessfulMsg().getText();		    
		    Assert.assertTrue(actSusccessMsg.contains(orgNAme));

	}
	
	@Test(groups = "regressionTest")
	public void createOrganizationWithIndustryTest() throws Throwable {
		/* read test Data from Excel */ 
		String orgNAme = excel.getExcelData("Org", "tc_02", "OrgName") +"_" + jLib.getRanDomData();
		String industryType = excel.getExcelData("Org", "tc_02", "Industry") ;

		/*step-2 : navigate to Org Page */
		Home hp = new Home(driver);
		  wlib.waitForElemnetVisibality(driver, hp.getOrgLnk());
		    hp.getOrgLnk().click();
		    
		/*step-3 : navigate to create ORg Page */
		Organizations op = new Organizations(driver);
			 wlib.waitForElemnetVisibality(driver, op.getCreateOrgImg());
		  op.getCreateOrgImg().click();
		  
		/*step-4 : create new ORg Page */
		    CreateNewOrg cno = new CreateNewOrg(driver);
		    cno.createOrg(orgNAme, industryType);
		    
		  /*verify Org NAme*/
		    OrgInformation coi = new OrgInformation(driver);
		    wlib.waitForElemnetVisibality(driver, coi.getSuccessfulMsg());
		    String actSusccessMsg = coi.getSuccessfulMsg().getText();		    
		    Assert.assertTrue(actSusccessMsg.contains(orgNAme));

	}
	
	

}





