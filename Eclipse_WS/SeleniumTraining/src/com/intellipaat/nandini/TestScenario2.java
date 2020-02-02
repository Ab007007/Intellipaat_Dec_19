package com.intellipaat.nandini;

import java.util.List;

import javax.sql.rowset.serial.SerialArray;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.intellipaat.actitime.utils.ApplicationUtils;
import com.intellipaat.actitime.utils.DriverUtils;

public class TestScenario2 {

	public static WebDriver driver = null;
	
	@BeforeTest
	public void setup()
	{
		driver = DriverUtils.getMyDriver();
		ApplicationUtils.launchApplication("https://www.amazon.com/");
	}

	@Test
	public static void searchProduct() throws InterruptedException {

		System.out.println("Searching for the Product : Electronics from Department List");
		// 1. Select 'Electronics' from Department drop down.

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(
				DriverUtils.getMyElement("xpath", "//select[@id='searchDropdownBox']//option[text()='Electronics']")));
		dropdown.click();

		// 2. Pass 'Televisions and Video' text to search box and click Search button
		DriverUtils.sendKeys("xpath", "//input[@id='twotabsearchtextbox']", "Televisions and Video");
		DriverUtils.click("xpath", "//div[input[@type='submit']]");

		// 3. Traversing the Department list from 'Televisions & Video' to 'Televisions'
		// page.

		DriverUtils.click("xpath",
				"//span[@class='a-list-item']/ancestor::div[@id='departments']//span[text()='Television & Video']");

		DriverUtils.click("xpath",
				"//span[@class='a-list-item']/ancestor::div[@id='departments']//span[text()='Televisions']");

		// 4. Click on Check box '32 inches and under'
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 200);");
		
		DriverUtils.click("xpath", "//li[@aria-label='32 Inches & Under']//i");
		DriverUtils.click("xpath", "//li[@aria-label='2017']//i");
		DriverUtils.sendKeys("name", "low-price", "25");
		DriverUtils.sendKeys("name", "high-price", "150");
		
		DriverUtils.click("xpath", "//span[@class='a-button-inner']//input");
			
		
		DriverUtils.click("xpath", "//span[@class='a-button-text a-declarative']");
		
		
	//	WebDriverWait wait  = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(DriverUtils.getMyElement("xpath", "//ul[@role='listbox']")));
		
		DriverUtils.click("xpath", "//a[text()='Price: Low to High']");
		Thread.sleep(5000);
		List<WebElement> searchResults = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		Thread.sleep(5000);
		System.out.println(searchResults.size());
		String name,value ;
		WebElement result;
		
		for (int i = 1; i<searchResults.size(); i++)
		{
			result=null;
			name = null;
			value = null;
			try
			{
				result = searchResults.get(i);
				js.executeScript("arguments[0].scrollIntoView();",result);
				name = result.getText();
				value = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal' and text()='"+name+"']/ancestor::div[@class='sg-row']//span[@class='a-price-whole']")).getText();
			}
			catch(Exception ex)
			{
				System.out.println("Exception Occured... No Value found ");
				System.out.println(name);
				value = "**********";
				break;
			}
			int valueInInteger = Integer.valueOf(value);
			if(valueInInteger <=150 )
			{
				Reporter.log("---------------------------------------------------------------<br>");
				Reporter.log("Name of the TV : " + name + "<br>");
				Reporter.log("Value of the TV : " + value + "<br>");
				Reporter.log("---------------------------------------------------------------<br>");
				System.out.println("Name of the TV : " + name + "Value of the TV : " + value );
			}
		}
		//span[@class='a-size-medium a-color-base a-text-normal' and text()='']/ancestor::div[@class='sg-row']//span[@class='a-price-whole']
		

	}

}
