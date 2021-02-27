package com.crm.comcast.contacttest;
/**
 * 
 * @author Deepak
 *
 */

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.objectrepositoryUtility.ContactInfoPage;
import com.crm.comcast.objectrepositoryUtility.Contacts;
import com.crm.comcast.objectrepositoryUtility.CreateNewContact;
import com.crm.comcast.objectrepositoryUtility.CreateNewOrg;
import com.crm.comcast.objectrepositoryUtility.Home;
import com.crm.comcast.objectrepositoryUtility.OrgInformation;
import com.crm.comcast.objectrepositoryUtility.Organizations;

public class CreateContact extends BaseClass{

	
	@Test(groups = "smokeTest")
	public void createContact() throws Throwable {
		/*read test Data */
		String contactNAme = excel.getExcelData("Contact", 4, 2);
		/*step-2:  navigate to Contact Page*/
		Home hp = new Home(driver);
		 wlib.waitForElemnetVisibality(driver, hp.getContactLnk());
		     hp.getContactLnk().click();
	 /*step-3:  navigate to create Contact Page*/
		Contacts cp = new Contacts(driver);
		 wlib.waitForElemnetVisibality(driver, cp.getCreateConatctImg());
		         cp.getCreateConatctImg().click();
     /*step-4:  create new Contact*/	       
		 CreateNewContact ccp = new CreateNewContact(driver);
				 ccp.createContact(contactNAme);;
		/*verify */     
	   ContactInfoPage cip = new ContactInfoPage(driver);
	   wlib.waitForElemnetVisibality(driver, cip.getSuccessfulMsg());
	   String actConactNAme = cip.getSuccessfulMsg().getText();
	   Assert.assertTrue(actConactNAme.contains(contactNAme));
	}
	
	
	
	
	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws Throwable {
		/*read test Data */
		String orgName = excel.getExcelData("Contact", 1, 2) + "_" + jLib.getRanDomData();
		String contactLastNAme = excel.getExcelData("Contact", 1, 3)+ "_" + jLib.getRanDomData();;
		

		System.out.println("create ORG ");
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
					    cno.createOrg(orgName);	
					    
					  /*verify Org NAme*/
					    OrgInformation coi = new OrgInformation(driver);
					    wlib.waitForElemnetVisibality(driver, coi.getSuccessfulMsg());
					    String actSusccessMsg = coi.getSuccessfulMsg().getText();		    
					    Assert.assertTrue(actSusccessMsg.contains(orgName));

						System.out.println("create contact  with above Org");
						 wlib.waitForElemnetVisibality(driver, hp.getContactLnk());
					     hp.getContactLnk().click();
					     
				 /*step-3:  navigate to create Contact Page*/
					Contacts cp = new Contacts(driver);
					 wlib.waitForElemnetVisibality(driver, cp.getCreateConatctImg());
					         cp.getCreateConatctImg().click();
					         
				 /*step-4:  create new Contact*/	       
					 CreateNewContact ccp = new CreateNewContact(driver);
							 ccp.createContact(contactLastNAme, orgName);
							 
					/*verify */     
				   ContactInfoPage cip = new ContactInfoPage(driver);
				   wlib.waitForElemnetVisibality(driver, cip.getSuccessfulMsg());
				   String actConactNAme = cip.getSuccessfulMsg().getText();
				   Assert.assertTrue(actConactNAme.contains(contactLastNAme));
		
	}
}
