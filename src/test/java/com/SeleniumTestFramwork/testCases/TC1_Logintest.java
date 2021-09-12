package com.SeleniumTestFramwork.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SelenimTestFramwork.pageObjects.Loginpage;


public class TC1_Logintest extends BaseClass {

	
	@Test
	public void Logintest() throws IOException
	{
		//driver.get(url);
		Loginpage lp = new Loginpage(driver);
		logger.info("Url is entered sucessfully");
		lp.setUserName(UserName);
		logger.info("User entered Sucessfully");
		
		lp.setPassword(Password);
		logger.info("Password entered sucessfully");
		lp.clickLogin();
		
		logger.info("Click on the login button sucessfully");
		if(driver.getTitle().contains("Home"))
		{
			captureScreen(driver, "Logintest");
			Assert.assertTrue(true);
			logger.info("Naigate to next page sucessfully");
		}
		else
		{
			captureScreen(driver, "Logintest");
			logger.info("Naigate to next page was not sucessfull");
			Assert.assertTrue(false);			
		}
		
	}

}
