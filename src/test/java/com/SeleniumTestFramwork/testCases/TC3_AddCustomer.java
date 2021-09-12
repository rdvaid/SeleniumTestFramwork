package com.SeleniumTestFramwork.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import com.SelenimTestFramwork.pageObjects.AddCustomerInfo;
import com.SelenimTestFramwork.pageObjects.Loginpage;
import com.SeleniumTestFramwork.utilities.XLUtils;

public class TC3_AddCustomer extends BaseClass {
	
	@Test(dataProvider="GetCustData")
	public void fn_AddCustomerDetails(String cusName,String custGen,String custDOB,String cust_Address,String custCity,String custState,String custPin,String CustMob,String custEmail,String custPwd) throws InterruptedException, IOException
	{
		// First we need to login to the page
		
		Loginpage lp = new Loginpage(driver);
		lp.setUserName("mngr351644");
		lp.setPassword("huhUhEs");
		lp.clickLogin();
		Thread.sleep(3000);		
		AddCustomerInfo objAdd = new AddCustomerInfo(driver);
		objAdd.fn_ClickCusName();
		Thread.sleep(9000);
		objAdd.fn_setCustName(cusName);
		objAdd.fn_selectGender();
		String []dob = custDOB.split("-");
		objAdd.fn_setCustDOB(dob[0],dob[1], dob[2]);
		Thread.sleep(1000);
		objAdd.fn_setCusAddress(cust_Address);
		objAdd.fn_setCuscity(custCity);
		objAdd.fn_setCusState(custState);
		objAdd.fn_setCusPin(custPin);
		Thread.sleep(1000);
		objAdd.fn_setCusMob(CustMob);
		String email= fn_getRandomIdforEmail(custEmail);		
		objAdd.fn_setCusEmail(email);
		Thread.sleep(1000);
		objAdd.fn_setCusPassword(custPwd);
		Thread.sleep(3000);
		objAdd.fn_ClickOnSubmit();
		Thread.sleep(9000);
		boolean strCheck= driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(strCheck)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else			
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	public String fn_getRandomIdforEmail(String emailid)
	{
		String randomEmail=RandomStringUtils.randomAlphabetic(5);
		String [] tempMailId = emailid.split("@");
		randomEmail=randomEmail + tempMailId[0] +"@" +tempMailId[1];
		return(randomEmail);
	}
	
	
	@DataProvider(name="GetCustData")
	String[][] getData() throws IOException
	{
       String path= System.getProperty("user.dir")+"/src/test/java/com/SeleniumTestFramwork/testData/TestData.xlsx";
		
		int rowNum = XLUtils.getRowCount(path,"Sheet2");
		int colCount = XLUtils.getCellCount(path,"Sheet2", 1);
		
		String loginData[][] = new String[rowNum][colCount];
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<colCount;j++)
			{				
			  loginData[i-1][j] = XLUtils.getCellData(path,"Sheet2", i, j);
			}
		}
		return(loginData);
	}
	

}
