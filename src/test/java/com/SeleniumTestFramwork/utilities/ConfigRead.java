package com.SeleniumTestFramwork.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigRead {
	
	Properties pro;
	FileInputStream fis;
	public ConfigRead()
	{
		File src_file = new  File("./Configuration/config.properties");
		
		pro = new Properties();
		
		try 
		{
			fis = new FileInputStream(src_file);
		} catch (FileNotFoundException e) 
		{
			System.out.println("Exception occured" + e.getMessage());
		}		
		try {
			pro.load(fis);
		} catch (IOException e) 
		{
			System.out.println("Exception occured" + e.getMessage());		
	    }
	  }
		
		public String fn_getAppUrl()
		{
			String strAppUrl = pro.getProperty("Appurl");			
			return(strAppUrl);		
		}
		 public String fn_getUserName()
	        {
	    	    String strUserName = pro.getProperty("UserName");
	    		return(strUserName);
	        }
	       public String fn_getPassword()
	       {
	    	 String strPassword = pro.getProperty("Password");
	    	 return(strPassword);
	       }
	       public String fn_getChromePath()
	       {
	    	  String strChromePath = pro.getProperty("chromepath");
	    	  return(strChromePath);
	         }
		
	}


