package com.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.JavaUtility;
@Listeners(com.crm.comcast.genericutility.ItestListenerIMP.class)
public class SampleTest extends BaseClass{
@Test
public void test() {
	Assert.assertTrue(false);
}
}
