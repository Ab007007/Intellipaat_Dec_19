package com.intellipaat.actitime.js;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.intellipaat.actitime.utils.DriverUtils;

import static com.intellipaat.actitime.utils.ActitimeUtils.*;

public class ScrollToViewDemo
{
	
	@Test
	public void javaScriptExecutorDemo()
	{
		WebDriver driver = getMyDriver();
		launchApplication("http://formy-project.herokuapp.com/scroll");
		
		scrollToElementVisible(DriverUtils.getMyElement("id", "name"));
	}

	
}
