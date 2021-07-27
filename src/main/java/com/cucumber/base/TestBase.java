package com.cucumber.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestBase {

	public static WebDriver driver;
	protected static WebDriverWait wait = null;
	public static Properties prop;
	
	public TestBase() {
		// Reading data from properties files
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\welcome\\eclipse-workspace-Oxygen\\Cucumber_Group_Assessment\\src\\main\\java\\com\\cucumber\\base\\config.properties");
		prop.load(ip);
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}
	// Launching of Chrome Driver
	public void launchBrowser()  {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{	System.setProperty("webdriver.chrome.driver",prop.getProperty("driverpath"));
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();		
		}
	
	// Launching of the Website
	public void launchURL() {
		driver.get(prop.getProperty("url"));
	}
	
	/*public void getTitle() {
		String title =driver.getTitle();
		Assert.assertEquals(title, "Your Store");
	}*/
	
	//Closing of the Chrome Browser
		public void closeBrowser() {
			driver.quit();
		}
	
}
