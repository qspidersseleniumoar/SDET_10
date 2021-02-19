package com.practice;

import org.testng.annotations.Test;

public class SeleniumCammanLineArgumnet {
	
	@Test
	public void sampleTest() {
		String BROWSER = System.getProperty("browser");
		String USER = System.getProperty("username");
		System.out.println(BROWSER);
		System.out.println(USER);
	}

}
