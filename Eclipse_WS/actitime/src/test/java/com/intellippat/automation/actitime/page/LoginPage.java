package com.intellippat.automation.actitime.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	@FindBy(id = "username")
	WebElement userNameTxtBox;
	
	
	@FindBy(name = "pwd")
	WebElement passwordTxtBox;
	
	
	@FindBy(id = "loginButton")
	WebElement loginButton;
	
	public void enterUserName(String userName)
	{
		userNameTxtBox.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		passwordTxtBox.sendKeys(password);
	}
	
	public void clickOnLogin()
	{
		loginButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login(String un,String pwd)
	{
		enterUserName(un);
		enterPassword(pwd);
		clickOnLogin();
	}
	
	
	public LoginPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
}
