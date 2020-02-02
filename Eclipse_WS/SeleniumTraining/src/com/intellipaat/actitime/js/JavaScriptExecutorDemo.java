package com.intellipaat.actitime.js;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.intellipaat.actitime.utils.ActitimeUtils.*;

public class JavaScriptExecutorDemo
{
	
	@Test
	public void javaScriptExecutorDemo()
	{
		WebDriver driver = getMyDriver();
		launchApplication("http://formy-project.herokuapp.com/scroll");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 1000);");
		
	}

}
