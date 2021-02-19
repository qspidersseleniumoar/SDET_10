package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadDataFromProperties {
	
	
	@Test
	public void sampleTest() throws IOException {
		/*Step 1 : get the Java Object of the Physical File*/
		FileInputStream fis = new FileInputStream("./commonData.properties");
		/*Step 2 : using Properties class load the Key */
		Properties pobj = new Properties();
		           pobj.load(fis); 
		/*Step 3 : read the value using getProperty(Key)*/
		        String BROWSER = pobj.getProperty("browser");  
		        String URL = pobj.getProperty("url");
		        String USERNAME = pobj.getProperty("username");
	}

}
