package com.cucumber.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.base.TestBase;

public class TC5_HomePage extends TestBase{
	
	@FindBy(xpath="//span[text()='1 business day']") WebElement ready;
	@FindBy(xpath="//span[contains(text(),'Transitional')]") WebElement style;
	 @FindBy(xpath="(//a[@title=\"Studio Chandelier(Polished Nickel/5 Lights)-OPEN BOX RETURN\"])[1]") WebElement prodimg;

	 public TC5_HomePage() {
	        PageFactory.initElements(driver, this);
	    }
	  
    //Apply the filter
	public void filter() throws InterruptedException
	{
		ready.click();
		  Thread.sleep(1000);

		  JavascriptExecutor javaScriptExecutor1 = (JavascriptExecutor)driver;
	      javaScriptExecutor1.executeScript("arguments[0].click()",style);
		  //style.click();
		  Thread.sleep(1000);

		System.out.println("filters supplied Successfully");
	}
	
	//select the product
	public void product()
	{
		JavascriptExecutor javaScriptExecutor1 = (JavascriptExecutor)driver;
	      javaScriptExecutor1.executeScript("arguments[0].click()",prodimg);
		//prodimg.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Products clicked Successfully");
		TakesScreenshot ts=(TakesScreenshot)driver;        
	    File source=ts.getScreenshotAs(OutputType.FILE);
	    try {
	        FileUtils.copyFile(source, new File("./screenshots/ProductsPage.png"));
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    System.out.println("The screenshot is taken");

	}
}
