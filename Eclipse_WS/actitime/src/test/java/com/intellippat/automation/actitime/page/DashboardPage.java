package com.intellippat.automation.actitime.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage 
{
	
	
	@FindBy(id = "logoutLink")
	WebElement logoutButton;
	
	
	public void  clickOnLogout()
	{
		logoutButton.click();
	}

	public DashboardPage(WebDriver driver)
	{

		PageFactory.initElements(driver, this);
	}
	
}
