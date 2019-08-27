package com.w2a.Utilities;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import com.w2a.base.TestBase;

public class validationPoint extends TestBase {
	
	public static boolean IsElementPresent(By by)
	{
		try{
			
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		
	}

}
