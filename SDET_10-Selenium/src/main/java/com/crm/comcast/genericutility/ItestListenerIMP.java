package com.crm.comcast.genericutility;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.comcast.events.Log;
/**
 * 
 * @author Nitheesha
 *
 */
public class ItestListenerIMP implements ITestListener {


	public void onFinish(ITestContext arg0) {					


	}		


	public void onStart(ITestContext arg0) {					


	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					


	}		


	public void onTestFailure(ITestResult result) {	
		
		String	date=new JavaUtility().getCurrentSystemDate().replace(" ", "_").replace(":", "_");
		try {
			WebDriverUtility wlib=new WebDriverUtility();
			wlib.takeScreenShot(result.getMethod().getMethodName()+date);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			

	}		


	public void onTestSkipped(ITestResult arg0) {					
						

	}		


	public void onTestStart(ITestResult arg0) {					
				

	}		


	public void onTestSuccess(ITestResult arg0) {					
		Log.info(arg0.getMethod().getMethodName()+" is passed");				

	}
}
