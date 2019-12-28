package com.intellipaat.actitime.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld
{

	public static void main(String[] args) {
		System.out.println("Hello all, Welcome to Selenium!!!");
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		System.out.println(System.getProperty("webdriver.chrome.driver"));
		WebDriver driver =  new ChromeDriver();
		driver.get("http://localhost/login.do");
		
		//WebElement userNameTextBox = driver.findElement(By.id("username"));
		driver.findElement(By.id("username")).sendKeys("admin");
		
		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		driver.findElement(By.id("loginButton")).click();
		
		//driver.close();
		
		
	}
}
