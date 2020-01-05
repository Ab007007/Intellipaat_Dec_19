package com.intellipaat.actitime.utils;

import org.openqa.selenium.WebDriver;

public class ActitimeUtils extends DriverUtils
{
	
	public static void launchActitime(String url)
	{
		System.out.println("---[INFO] launching application  " + url);
		driver.get(url);
	}

}
