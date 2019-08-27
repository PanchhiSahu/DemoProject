package com.w2a.DataReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
 // Load data from the properties file 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Loading Cofing data   
	     Properties config= new Properties();
		 FileInputStream fis1= new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\Config.properties");
		 config.load(fis1);
		 System.out.println(config.getProperty("browser"));
		 
		//Loading ObjectRepository data 
		 Properties obj_rep= new Properties();
		 FileInputStream fis2= new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\OR.properties");
		 obj_rep.load(fis2);
		 System.out.println(obj_rep.getProperty("BankMngLgBtn"));
		 
		//System.out.println(System.getProperty("user.dir")+ "\\Driver\\chromedriver.exe");
		 
	}

}
