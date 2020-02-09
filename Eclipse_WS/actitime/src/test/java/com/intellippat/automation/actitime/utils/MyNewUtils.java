package com.intellippat.automation.actitime.utils;

import java.util.Date;

import org.testng.annotations.Test;

public class MyNewUtils {

	
	public static void testMe()
	{
		System.out.println("I'm from diffrent Project");
		
	}
	
	public static String getCurrentDateAndTime()
	{
		return new Date().toString().replace(" ", "_").replace(":", "_");
	}
}
