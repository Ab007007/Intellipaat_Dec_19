package com.intellipaat.actitime.testng;

import org.testng.annotations.DataProvider;

public class TestData 
{
	
	@DataProvider
	public Object[][] dp()
	{
		return new Object[][] 
		{ 
			new Object[] { 1, "a" }, 
			new Object[] { 2, "b" }, 
			new Object[] { 3, "c" }, 
			new Object[] { 4, "d" }, 
			new Object[] { 5, "e" }, 
			new Object[] { 6, "f" }, 
			new Object[] { 7, "g" }, 
			new Object[] { 8, "h" }, 
			new Object[] { 9, "i" }, 
			new Object[] { 10, "j" }, 
		};
	}

	
	@DataProvider
	public Object[][] customerData()
	{
		return new Object[][] 
		{ 
			new Object[] { "DP-Dec-Customer1","DP-Dec-Customer-Desc-1"}, 
			new Object[] { "DP-Dec-Customer2","DP-Dec-Customer-Desc-2"}, 
			new Object[] { "DP-Dec-Customer3","DP-Dec-Customer-Desc-3"}, 
			new Object[] { "DP-Dec-Customer4","DP-Dec-Customer-Desc-4"}, 
		};
	}
	
	
	
}
