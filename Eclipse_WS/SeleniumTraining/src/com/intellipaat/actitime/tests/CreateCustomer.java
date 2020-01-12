package com.intellipaat.actitime.tests;

import org.openqa.selenium.WebDriver;

import com.intellipaat.actitime.utils.ActitimeUtils;

public class CreateCustomer {

	private static WebDriver driver = null;
	public static void main(String[] args) {
		
		System.out.println("--- Welcome to Customer Creation ---");
		driver = ActitimeUtils.getMyDriver();
	
		ActitimeUtils.launchApplication("http://localhost/login.do");
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.selectModule("tasks");
		ActitimeUtils.clickOnNewCustomerButton();
		ActitimeUtils.createNewCustomer("Int-Second-Cust-Dec", "Int-Second-Cust-Dec-Desc");
		ActitimeUtils.logout();
		
	}
}
