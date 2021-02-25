package com.practice;

import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;

public class DataDarivenTest {
	
	@Test
	public void sampeDataTest() throws Throwable {
		ExcelUtility excel = new ExcelUtility();
		int  rowIndex = excel.getRowCount("booktTicketTest");
		System.out.println(rowIndex);
	}

}
