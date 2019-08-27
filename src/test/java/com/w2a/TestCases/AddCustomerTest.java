package com.w2a.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.Utilities.handlePopUp;
import com.w2a.Utilities.validationPoint;
import com.w2a.base.TestBase;

import POM.LoginPage;

public class AddCustomerTest extends TestBase{
	
	static int count=1;
	
	@Test(dependsOnGroups="BankManagerLogin.loginAsBankManager", dataProvider="getData")
	public void addNewCustomer(String fName, String lName, String pincode) throws InterruptedException
	{
		
		//Verify that the Add customer button exist 
 		AssertJUnit.assertTrue(validationPoint.IsElementPresent(By.xpath(OR.getProperty("AdCustomerBtn"))));
		log.debug("Add Customer Button Exist");
		//Clicked on add customer button 
		WebElement addcusbtn= driver.findElement(By.xpath(OR.getProperty("AdCustomerBtn")));
		addcusbtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Enter customer firstname
		WebElement fname= driver.findElement(By.xpath(OR.getProperty("FirstName")));
		fname.click();
		fname.sendKeys(fName);
		//Enter customer lastname
		driver.findElement(By.xpath(OR.getProperty("LastName"))).click();
		driver.findElement(By.xpath(OR.getProperty("LastName"))).sendKeys(lName);
		//Enter customer postcode
		driver.findElement(By.xpath(OR.getProperty("PostCode"))).click();
		driver.findElement(By.xpath(OR.getProperty("PostCode"))).sendKeys(pincode);
		//Click on submit button
		driver.findElement(By.xpath(OR.getProperty("AddCusSubBtn"))).click();
		Thread.sleep(3000);
		//Dynamic pop up handling 
		String text_popup= handlePopUp.getPopUpText();
		System.out.println(text_popup);
		log.debug("!!!!Added New Customer Sucessfully!!!!");
		
		if (count==4)
		{
			System.out.println(count);
			Thread.sleep(3000);
			driver.close();
		}
		else
		{
			System.out.println(count);
			count++;
			driver.findElement(By.xpath("//button[@class='btn home']")).click();
			LoginPage.BankManager(driver).click();
			
		}
			
				
		
	}
	
	
}
