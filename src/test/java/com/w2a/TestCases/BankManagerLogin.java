package com.w2a.TestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
public class BankManagerLogin  extends TestBase{

	@Test(groups={"BankManagerLogin.loginAsBankManager"})
	public static void loginAsBankManager() throws InterruptedException
	{
		//Login as BankManager
		WebElement element =  driver.findElement(By.cssSelector("div > div:last-child > .btn.btn-primary.btn-lg"));
		element.click();
		log.debug("Login As BankManager");
		Thread.sleep(3000);
		
}

}