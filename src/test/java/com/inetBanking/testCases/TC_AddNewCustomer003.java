package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddingNewCustomer;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddNewCustomer003 extends BaseClass
{
	@Test
	public void addNewCustomer()
	{
		LoginPage lp=new LoginPage(driver);
		logger.info("URL Entered");
		
		lp.setUserName(userName);
		logger.info("Username Entered");
		
		lp.setPwd(password);
		logger.info("Password Entered");
		
		lp.setLogin();
		
		AddingNewCustomer ac=new AddingNewCustomer(driver);
		
		ac.newCustomer();
		
		ac.custName("Abhishek");
		ac.gender();
		ac.date("10", "8", "1995");
		ac.textArea("Bhosari");
		ac.city("Pune");
		ac.state("Maharastra");
		ac.pin("411039");
		ac.mobileNo("9822595480");
		ac.email("xxxxx@gmail.com");
		ac.pswrd("123456789");
		ac.submit();
		
		logger.info("customer added");
		
		driver.switchTo().alert().accept();
		
		String title=driver.getTitle();
		
		if(title.equals("Guru99 Bank New Customer Entry Page"))
		{
			Assert.assertTrue(true, "Test Case passed");
			logger.info("Test Passsed");
		}
		else
		{
			Assert.assertTrue(false, "Test Case Failed");
			logger.info("Test  Failed");
		}
		
		
		
		
		
		
	}

}
