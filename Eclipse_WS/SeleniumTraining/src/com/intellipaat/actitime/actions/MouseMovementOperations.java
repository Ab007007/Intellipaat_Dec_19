package com.intellipaat.actitime.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intellipaat.actitime.utils.ActitimeUtils;

public class MouseMovementOperations {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchActitime("https://www.flipkart.com/");
		
		WebDriverWait wait  =  new WebDriverWait(driver, 10);
		WebElement closeElement = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='_3Njdz7']/button"))));
		
		closeElement.click();
		
		Actions act = new Actions(driver);

		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Women']"))).perform();

		Thread.sleep(2000);

		act.moveToElement(driver.findElement(By.xpath("//span[text()='Men']"))).perform();
		Thread.sleep(2000);

		act.moveToElement(driver.findElement(By.xpath("//span[text()='Baby & Kids']"))).perform();
		Thread.sleep(2000);

		act.moveToElement(driver.findElement(By.xpath("//span[text()='Sports, Books & More']"))).perform();

	}

}
