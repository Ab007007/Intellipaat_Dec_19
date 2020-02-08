package com.intellippat.automation.actitime;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest
{
	static WebDriver driver =null;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void loginWithValidCreds() throws InterruptedException
	{
		
		driver.get("http://localhost/login.do");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		
		
		driver.findElement(By.id("logoutLink")).click();
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		
	}
	
	
	@Test
	public void loginWithInValidCreds() throws InterruptedException
	{
		driver.get("http://localhost/login.do");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		
		driver.findElement(By.id("username")).sendKeys("admin1");
		driver.findElement(By.name("pwd")).sendKeys("manager1");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		
	}
	
	@AfterTest
	public void cleanUp()
	{
		driver.close();
	}

}
