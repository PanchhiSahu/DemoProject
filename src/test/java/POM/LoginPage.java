package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{
	

	public static WebElement BankManager(WebDriver driver) throws InterruptedException
	{
		//Login as BankManager
		//log.debug("Login As BankManager");
		WebElement element =  driver.findElement(By.cssSelector("div > div:last-child > .btn.btn-primary.btn-lg"));
		Thread.sleep(3000);
		
		return element;	
	}
	
}