package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilites.ReadConfig;


public class BaseClass
{
	ReadConfig rc=new ReadConfig();
	
	public String BaseUrl= rc.getApplicationUrl();
	public String userName=rc.getUserName();
	public String password=rc.getPwd();
	public static WebDriver driver;
	Logger logger;
	
    @Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		
		 logger=Logger.getLogger("eBanking");
		 PropertyConfigurator.configure("Log4j.properties");
		 
		 if(br.equals("firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
				driver=new FirefoxDriver();
		 }
		 else if(br.equals("IE"))
		 {
			 System.setProperty("webdriver.ie.driver", rc.getIEPath());
			 driver=new InternetExplorerDriver();
		 }
		 else if(br.equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			 driver=new ChromeDriver();
		 }
		 
		 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		 
		 driver.get(BaseUrl);
		 
		 
	
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver ;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println(" Screenshot Taken ");
		
	}
	
	
	
	
	
	
	

}
