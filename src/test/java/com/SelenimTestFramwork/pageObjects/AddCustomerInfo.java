package com.SelenimTestFramwork.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerInfo {
	WebDriver driver;
	
	public AddCustomerInfo(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//a[text()=\"New Customer\"]" )
	@CacheLookup
	WebElement lnkAddCustomer;
	
	@FindBy(how=How.XPATH,using="//input[@name=\"name\"]")
	@CacheLookup
	WebElement txtCusName;
	
	@FindBy(how=How.XPATH,using="//input[@value=\"m\"]")
	@CacheLookup
	WebElement rdCustSex;
    
	@FindBy(how=How.XPATH,using="//input[@id=\"dob\"]")
	@CacheLookup
	WebElement txtCusDob;
	
	@FindBy(how=How.XPATH,using="//textarea[@name=\"addr\"]")
	@CacheLookup
	WebElement txtCusAddress;
	
	@FindBy(how=How.XPATH,using="//input[@name=\"city\"]")
	@CacheLookup
	WebElement txtCusCity;
	
	@FindBy(how=How.XPATH,using="//input[@name=\"state\"]")
	@CacheLookup
	WebElement txtCusState;
	
	@FindBy(how=How.XPATH,using="//input[@name=\"pinno\"]")
	@CacheLookup
	WebElement txtCusPin;
	
	@FindBy(how=How.XPATH,using="//input[@name=\"telephoneno\"]")
	@CacheLookup
	WebElement txtCusMob;
	
	@FindBy(how=How.XPATH,using="//input[@name=\"emailid\"]")
	@CacheLookup
	WebElement txtCusEmail;
	
	@FindBy(how=How.XPATH,using="//input[@name=\"password\"]")
	@CacheLookup
	WebElement txtCusPassword;
	
	@FindBy(how=How.XPATH,using="//input[@value=\"Submit\"]")
	@CacheLookup
	WebElement btnsubmit;
	
	public void fn_ClickCusName()
	{
		lnkAddCustomer.click();
	}
	
	public void fn_setCustName(String custName)
	{
		txtCusName.sendKeys(custName);
	}
	
	public void fn_selectGender()
	{
		rdCustSex.click();
	}
	public void fn_setCustDOB(String mm,String dd, String yy)
	{
		txtCusDob.sendKeys(mm);
		txtCusDob.sendKeys(dd);
		txtCusDob.sendKeys(yy);		
	}
    public void fn_setCusAddress(String cusAddreess)
    {
    	txtCusAddress.sendKeys(cusAddreess);
    }
    public void fn_setCuscity(String cusCity)
    {
    	txtCusCity.sendKeys(cusCity);
    }
    public void fn_setCusState(String cusState)
    {
    	txtCusState.sendKeys(cusState);
    }
    public void fn_setCusPin(String cusPin)
    {
    	txtCusPin.sendKeys(String.valueOf(cusPin));
    }
    public void fn_setCusMob(String cusMob)
    {
    	txtCusMob.sendKeys(cusMob);
    }    
    public void fn_setCusEmail(String cusEmail)
    {
    	txtCusEmail.sendKeys(cusEmail);
    }
    public void fn_setCusPassword(String cusPasswrd)
    {
    	txtCusPassword.sendKeys(cusPasswrd);
    }    
    public void fn_ClickOnSubmit()
    {
    	btnsubmit.click();    	
    }
    
}

