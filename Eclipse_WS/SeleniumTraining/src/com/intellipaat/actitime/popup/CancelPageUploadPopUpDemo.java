package com.intellipaat.actitime.popup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.intellipaat.actitime.utils.ActitimeUtils;

public class CancelPageUploadPopUpDemo {
	
	public static void main(String[] args) throws IOException {
	
		WebDriver driver=  ActitimeUtils.getMyDriver();
		
		ActitimeUtils.launchApplication("https://formy-project.herokuapp.com/fileupload");
		
		ActitimeUtils.click("xpath", "//button[text()='Choose']");
		
		Runtime.getRuntime().exec("D:\\Intellipaat\\Intellipaat_08_December\\autoit\\cancelPageUploadPopUp.exe");
		
		
		System.out.println("Popup Handled");
		
	}

}
