package com.SeleniumTestFramwork.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SelenimTestFramwork.pageObjects.Loginpage;
import com.SeleniumTestFramwork.utilities.XLUtils;

public class TC2_LoginDD extends BaseClass{

	@Test(dataProvider="TestData")
	public void loginDD(String uname, String pwd) throws InterruptedException
	{
		Loginpage lp = new Loginpage(driver);
		lp.setUserName(uname);
		logger.info("user id Provided");
		lp.setPassword(pwd);
		logger.info("user password is provided ");
		lp.clickLogin();
		Thread.sleep(3000);
		if(isAlertWindow())			
		{
			driver.switchTo().alert().accept();;
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login was not sucessfull");
			
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("login was sucessfull and user sucessfully logout");
		}
	}
	
	public boolean isAlertWindow()
	{
		try
		{
		 driver.switchTo().alert();
		 return(true);
		}
		catch(NoAlertPresentException e)
		{
			 return(false);
		}
	}
	
	@DataProvider(name="TestData")
   String [][] getData() throws IOException
     {
		String path= System.getProperty("user.dir")+"/src/test/java/com/SeleniumTestFramwork/testData/TestData.xlsx";
		
		int rowNum = XLUtils.getRowCount(path,"Sheet1");
		int colCount = XLUtils.getCellCount(path,"Sheet1", 1);
		
		String loginData[][] = new String[rowNum][colCount];
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<colCount;j++)
			{				
			  loginData[i-1][j] = XLUtils.getCellData(path,"Sheet1", i, j);
			}
		}
		return(loginData);
     }
	
}

