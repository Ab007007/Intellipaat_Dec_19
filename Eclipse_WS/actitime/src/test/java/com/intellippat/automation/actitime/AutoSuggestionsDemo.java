package com.intellippat.automation.actitime;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestionsDemo {

	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("--- Welcome to Autosuggestions Display Automation Test Flow ---");
		
		WebDriverManager.phantomjs().setup();
		PhantomJSDriver driver = new PhantomJSDriver();
			
		//HtmlUnitDriver driver = new HtmlUnitDriver();
		//driver.setJavascriptEnabled(true);
		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.name("q")).sendKeys("Intellipaat");

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		 
		 System.out.println("Title of the page is -> " + driver.getTitle());
		
//		Thread.sleep(2000);
//		List<WebElement> suggestions = driver.findElements(By.xpath("//h3"));
//		
//		System.out.println("-- Total suggestions displayed --" + suggestions.size());
//		for(WebElement suggestion : suggestions)
//		{
//			System.out.println(suggestion.getText());
//		}
//			
		
	}
}
