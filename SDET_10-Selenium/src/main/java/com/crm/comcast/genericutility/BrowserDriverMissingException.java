package com.crm.comcast.genericutility;
/**
 * 
 * @author Nitheesha
 *
 */
public class BrowserDriverMissingException extends IllegalStateException{
	
	public BrowserDriverMissingException() {
		
		System.out.println("Browser driver missing!!!");
	}

}
