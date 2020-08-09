package com.inetBanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration\\Config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("BaseUrl");
		return url;
	}
	
	public String getUserName()
	{
		String name=pro.getProperty("userName");
		return name;
	}
	
	public String getPwd()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath=pro.getProperty("firefoxpath");
		return firefoxPath;
	}
	
	public String getIEPath()
	{
		String iePath=pro.getProperty("iepath");
		return iePath;
	}
	
	public String getChromePath()
	{
		String chromePath=pro.getProperty("chromepath");
		return chromePath;
	}

}







