package com.crm.comcast.genericutility;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzer implements IRetryAnalyzer{
	int counter=0;
	int retrylimit=4;

	
	public boolean retry(ITestResult result) {
		if(counter<retrylimit) {
			counter++;
			return true;
		}
		return false;
	}
	
	
	@Test(retryAnalyzer = com.crm.comcast.genericutility.RetryAnalyzer.class)
	public void test() {
		Assert.assertTrue(false);
	}
		

}
