package com.intellipaat.actitime.testng;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.intellipaat.actitime.utils.ActitimeUtils;
import com.intellipaat.actitime.utils.DriverUtils;

public class CreateProject {

	WebDriver driver = null;
	@BeforeTest
	public void setup()
	{
		driver = DriverUtils.getMyDriver();
		
	}
	
	@Parameters({"url"})
	@BeforeClass
	public void launchApplication(String url)
	{
		driver.get(url);
	}
	
	@Parameters({"username","password"})
	@BeforeMethod
	public void login(String un, String pwd)
	{
		ActitimeUtils.login(un, pwd);
	}
	
	@Test
	public void createProjectTest()
	{
		
	}
	
	@AfterMethod
	public void logout()
	{
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		
	}
	
	
	
	
	
	
	
}
