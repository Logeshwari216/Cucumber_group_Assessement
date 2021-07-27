package com.cucumber.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.TestBase;

public class TC11_RemoveProduct extends TestBase{
	
	@FindBy(xpath="(//button[text()='ADD TO CART'])[1]") WebElement addcart;
	@FindBy(xpath="//span[text()='Cart']") WebElement view;
	@FindBy(xpath="(//span[text()='Remove'])[1]") WebElement remove;
	
	public TC11_RemoveProduct() {
        PageFactory.initElements(driver, this);
    }

	public void add()
	{
		JavascriptExecutor javaScriptExecutor1 = (JavascriptExecutor)driver;
	      javaScriptExecutor1.executeScript("arguments[0].click()",addcart);
		//addcart.click();
		System.out.println("Added successfully");
	}
	public void view()
	{
		view.click();
		System.out.println("Viewed the product successfully");
	}
	public void remove()
	{
		JavascriptExecutor javaScriptExecutor1 = (JavascriptExecutor)driver;
	      javaScriptExecutor1.executeScript("arguments[0].click()",remove);
		//remove.click();
		System.out.println("Removed successfully");
		driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);

		TakesScreenshot ts=(TakesScreenshot)driver;        
	    File source=ts.getScreenshotAs(OutputType.FILE);
	    try {
	        FileUtils.copyFile(source, new File("./screenshots/RemoveProduct.png"));
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    System.out.println("The screenshot is taken");


	}
}
