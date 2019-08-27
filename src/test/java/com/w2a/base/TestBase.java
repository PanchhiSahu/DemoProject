package com.w2a.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.w2a.DataReader.ExcelReader;




public class TestBase {
	
	public static WebDriver driver;
	public static Properties config= new Properties();
	public static Properties OR= new Properties();
	public static FileInputStream fis;
	public static Logger log= Logger.getLogger("devpinoyLogger");
	public static ExcelReader reader= new ExcelReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\excel\\"
						+ "TestData.xlsx");
	public static WebDriverWait wait;
	
	@Parameters({"browser"})
	@Test
	public void browserSetUp(String browser) throws IOException, InterruptedException
	{
		
		if (driver==null)
		{
			try {
				fis= new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\"
						+ "Config.properties");
			    } 
		    catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			
			config.load(fis);
			log.debug("Config File loaded sucessfully");
			
			fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\"
					+ "OR.properties");
			OR.load(fis);
			log.debug("OR File loaded sucessfully");
			
			
		
	   // if (config.getProperty("browser").equals("chrome"))
	    	if(browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\Driver2\\chromedriver.exe");
			driver= new ChromeDriver();
			log.debug("Chrome Browser Launched!!!");
			System.out.println("Chrome Browser Launched!!!");
			}
		
	   // else if (config.getProperty("browser").equals("firefox"))
	      else if (browser.equals("firefox")) 
	   
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "\\Driver2\\geckodriver.exe");
			driver= new FirefoxDriver();
			log.debug("Firefox Browser Launched!!!");
			System.out.println("Firefox Browser Launched!!!");
			}
		
		else{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\Driver2\\chromedriver.exe");
			driver= new ChromeDriver();
			log.debug("Chrome Browser Launched!!!");
			System.out.println("Chrome Browser Launched!!!");
			}
		
		driver.get(config.getProperty("url"));
		Thread.sleep(3000);
		log.debug("Website Launched!!!");
		driver.manage().window().maximize();
		
		}	
	
	}
	

	
	@DataProvider
	public Object[][] getData(Method m)
	{
		String sheetName= m.getName();
		System.out.println(sheetName);
		int rows= reader.getRowCount(sheetName);
		int cols=reader.getColumnCount(sheetName);
		
		Object [][] data= new Object[rows-1][cols];
		
		for (int rowNum= 2; rowNum <=rows; rowNum++) {
			
			for (int colNum = 0; colNum <cols; colNum++) {
				
				data[rowNum-2][colNum]=reader.getCellData(sheetName,colNum,rowNum);			
			}
				
		}
		
		return data;
		
	}
	
}
