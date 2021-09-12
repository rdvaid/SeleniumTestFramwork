

package com.SeleniumTestFramwork.testCases;
import com.SeleniumTestFramwork.utilities.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static String url=new ConfigRead().fn_getAppUrl();
	
	public static String UserName=new ConfigRead().fn_getUserName();
	public static String Password=new ConfigRead().fn_getPassword();
	public static String browser =new ConfigRead().fn_getChromePath();
	public static WebDriver driver ;	
	public static Logger  logger;
	
	@Parameters("getBrowser")
	@BeforeClass 
	public void setup(String br)
	{
	  	logger= Logger.getLogger("TestFramwork");
		PropertyConfigurator.configure("log4j.properties");	  
		if(br.equals("chrome"))
		{
		// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//Drivers\\chromedriver.exe");
		    driver = new ChromeDriver();		   
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "//Drivers\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		}
		else if(browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+ "//Drivers\\msedgedriver.exe");
		    driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
