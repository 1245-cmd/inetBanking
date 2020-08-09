package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest001 extends BaseClass
{
	
	@Test
	public void loginTest() throws IOException
	{
		
		
		LoginPage lp=new LoginPage(driver);
		logger.info("URL Entered");
		
		lp.setUserName(userName);
		logger.info("Username Entered");
		
		lp.setPwd(password);
		logger.info("Password Entered");
		
		lp.setLogin();
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}

	}

}
