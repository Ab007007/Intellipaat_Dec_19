package com.intellippat.automation.actitime.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AutoSuggestionsDemo {

	@Test
	public void gridTest() throws MalformedURLException
	{
		System.out.println("--- Welcome to Autosuggestions Display Automation Test Flow ---");
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		
	String nodeUrl  = "http://192.168.0.108:4455/wd/hub";
//		String nodeUrl  = "http://192.168.56.1:5555/wd/hub";
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.addArguments("disable-infobars");
		
		WebDriver driver = new RemoteWebDriver(new URL(nodeUrl),options);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Intellipaat");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> suggestions = driver.findElements(By.xpath("//li[@class='sbct']"));
		
		System.out.println("-- Total suggestions displayed --" + suggestions.size());
		for(WebElement suggestion : suggestions)
		{
			System.out.println(suggestion.getText());
		}
		
		driver.close();
		
	}
}
