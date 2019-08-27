
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base { 

	static String browserName="Firefox";
	static String chrome_exePath="E:\\Workspace\\DataDrivenFramework\\Driver\\chromedriver.exe";
	static String FF_exePath="E:\\Workspace\\DataDrivenFramework\\Driver\\geckodriver.exe";

	static WebDriver getBrowserInstance(String browserName)
	{
		if (browserName=="Chrome")
			
		{
			System.setProperty("webdriver.chrome.driver", chrome_exePath);
			return new ChromeDriver();
		}
		
		
		else if (browserName=="Firefox")
		{
			System.setProperty("webdriver.gecko.driver", FF_exePath);
			return new FirefoxDriver();
			
		}
			
		else 
		{
			System.setProperty("webdriver.chrome.driver", chrome_exePath);
			return new ChromeDriver();
		}
		
	}
	
	public static void main(String[] args) {

		//Concept of polymorphism
		WebDriver driver= getBrowserInstance(browserName);
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.getCurrentUrl();
		
	}

}
