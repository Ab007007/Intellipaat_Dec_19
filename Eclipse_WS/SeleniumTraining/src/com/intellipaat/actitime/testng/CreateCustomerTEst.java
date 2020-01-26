package com.intellipaat.actitime.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateCustomerTEst {

	
	@BeforeTest
	public void launch()
	{
		
		
	}
	
	@BeforeMethod
	public void login()
	{
		
	}
	
	
	@Test(priority = 2)
	public void createCustomer()
	{
		
	}
	
	@Test(priority = 1)
	public void createProject()
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
