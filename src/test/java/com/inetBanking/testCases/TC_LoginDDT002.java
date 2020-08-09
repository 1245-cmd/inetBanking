package com.inetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilites.XLUtils;

public class TC_LoginDDT002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String username, String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPwd(pwd);
		lp.setLogin();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			
			lp.setLogout();
			
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			
			driver.switchTo().alert().accept();
			//close logout alert
			
			
			driver.switchTo().defaultContent();
			
		
		}


	}
	
	public boolean isAlertPresent()
	{
		
		try
		{
		driver.switchTo().alert();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		return true;
		}
		
	   catch(Exception e)
		{
		   return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/New Microsoft Excel Worksheet (2).xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int columnum=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rownum][columnum];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<columnum; j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return loginData;
		
		
	
		
	}
	

}
