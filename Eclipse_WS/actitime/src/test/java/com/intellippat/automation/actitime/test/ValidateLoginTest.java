package com.intellippat.automation.actitime.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.intellippat.automation.actitime.page.DashboardPage;
import com.intellippat.automation.actitime.page.LoginPage;
import com.intellippat.automation.actitime.utils.MyNewUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateLoginTest 
{
	WebDriver driver = null;
	LoginPage loginPage = null;
	DashboardPage dbPage = null;
	ExtentReports reports = null;
	ExtentTest test = null;
	
	
	
	@BeforeSuite
	public void setupReports()
	{
		String file ="reports\\test_Execution_report_" + MyNewUtils.getCurrentDateAndTime()+ ".html";
		//FileInputStream fis = new FileInputStream(file);
		reports = new ExtentReports(file, false);
	}
	
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		loginPage = new LoginPage(driver);
		dbPage = new DashboardPage(driver);
		
		
	}
	
	@Test(priority = 1)
	public void loginWithValidCreds()
	{
		test = reports.startTest("loginWithValidCreds test started..");
		test.log(LogStatus.INFO	, "Launching application");
		driver.get("http://localhost/login.do");
		test.log(LogStatus.PASS, "Application launched successfully");
		loginPage.login("admin", "manager");
		test.log(LogStatus.PASS, "Application Logged in successfully");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		test.log(LogStatus.PASS, "DashBoard Displayed Successfully");
		dbPage.clickOnLogout();
		test.log(LogStatus.PASS, "Logged out successfully");
		reports.endTest(test);
		
	}
	
	
	@Test(priority = 2)
	public void loginWithInValidCreds()
	{
		test = reports.startTest("loginWithInValidCreds test started..");
		test.log(LogStatus.INFO	, "Launching application");
		
		driver.get("http://localhost/login.do");
		test.log(LogStatus.PASS, "Application launched successfully");
		
		loginPage.login("admin1", "manager1");
		test.log(LogStatus.PASS, "Didnot  Logged in with invalid credentials");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		reports.endTest(test);
		
		
	}
	
	@AfterTest
	public void cleaup()
	{
		
		driver.close();
		driver = null;
		loginPage = null;
		dbPage = null;
		
	}
	

	@AfterSuite
	public void saveReports()
	{
		reports.flush();
		reports = null;
		
	}
}
