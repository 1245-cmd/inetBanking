package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddingNewCustomer 
{
	
	WebDriver rdriver;
	
	public AddingNewCustomer(WebDriver ldriver )
	{
		rdriver=ldriver;
		
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement newCustomer;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
	WebElement customerName;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	WebElement gender;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"dob\"]")
	WebElement date;
	
	@FindBy(how=How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
	WebElement textArea;
	
	@FindBy(how=How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")
	WebElement city;
	
	@FindBy(how=How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")
	WebElement state;
	
	@FindBy(how=How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input")
	WebElement pinNo;
	
	@FindBy(how=How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input")
	WebElement mobileNo;
	
	@FindBy(how=How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input")
	WebElement emailId;
	
	@FindBy(how=How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input")
	WebElement pwd;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")
	WebElement submit;
	
	public void newCustomer()
	{
		newCustomer.click();
	}
	
	public void custName(String name)
	{
		customerName.sendKeys(name);
	}
	
	public void gender()
	{
		boolean x=gender.isSelected();
		
		if(x==true)
		{
			gender.click();
		}
	}
	
	public void date(String mm, String dd, String yy)
	{
		date.sendKeys(mm);
		date.sendKeys(dd);
		date.sendKeys(yy);

	}
	
	public void textArea(String area)
	{
		textArea.sendKeys(area);
	}
	
	public void city(String cit)
	{
		city.sendKeys(cit);
	}
	
	public void state(String stat)
	{
		state.sendKeys(stat);
	}
	
	public void pin(String pi)
	{
		pinNo.sendKeys(pi);
	}
	
	public void mobileNo(String no)
	{
		mobileNo.sendKeys(no);
	}
	
	public void email(String id)
	{
		emailId.sendKeys(id);
	}
	
	public void pswrd(String pwr)
	{
		pwd.sendKeys(pwr);
	}
	
	public void submit()
	{
		submit.click();
	}
	

	
	
	

}
