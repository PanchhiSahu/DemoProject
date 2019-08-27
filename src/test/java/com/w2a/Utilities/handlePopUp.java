package com.w2a.Utilities;

import com.w2a.base.TestBase;

public class handlePopUp extends TestBase{
	
	public static String getPopUpText()
	{
		String txt_msg=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
	return txt_msg;
	}

}
