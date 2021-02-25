package com.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.EclipseInterface;

import com.crm.comcast.genericutility.ExcelUtility;

public class DataProviderTest {
	@Test(dataProvider = "getData")
	public void sampeDataTest(String src , String dst) {
		System.out.println("Source ==>"+src   +"     destination==>"+dst);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		
		ExcelUtility excel = new ExcelUtility();
		int  rowIndex = excel.getRowCount("booktTicketTest");
		Object[][] objArr = new Object[rowIndex][2];
		for(int i=0 ; i<rowIndex; i++) {
	       objArr[i][0] = excel.getExcelData("booktTicketTest", i, 0);
	       objArr[i][1] = excel.getExcelData("booktTicketTest", i, 1);
		}
		return objArr;		
	}

}
