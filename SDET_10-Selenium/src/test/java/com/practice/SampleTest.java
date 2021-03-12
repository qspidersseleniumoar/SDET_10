package com.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
@Listeners(com.crm.comcast.genericutility.ItestListenerIMP.class)
public class SampleTest extends BaseClass{
@Test
public void test() {
	
	logger.info("This test case got failed");
	Assert.assertTrue(false);
}
}
