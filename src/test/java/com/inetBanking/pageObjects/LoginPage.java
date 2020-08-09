package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver rDriver;
	
	public LoginPage(WebDriver lDriver)
	{
		rDriver=lDriver;
		PageFactory.initElements(lDriver, this);
	}
	
	@FindBy(name="uid")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(name="btnLogin")
	WebElement login;
	
	@FindBy(linkText="Log out")
	WebElement logout;
	
	public void setUserName(String name)
	{
		txtUsername.sendKeys(name);
	}
	
	public void setPwd(String pwd1)
	{
		pwd.sendKeys(pwd1);
	}
	
	public void setLogin()
	{
		login.click();
	}
	
	public void setLogout()
	{
		logout.click();
	}

	

}
