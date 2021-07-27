package com.cucumber.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.TestBase;

public class TC4_Tab extends TestBase{
	
	@FindBy(xpath="//span[@title='Lighting']") WebElement light;
	@FindBy(xpath="//a[@title='Ceiling Lights']") WebElement ceil;
	@FindBy(xpath="//a[@title='Ceiling Lights Chandeliers']") WebElement chandel;
	@FindBy(xpath="//a[text()='large chandelier']") WebElement large;
	
	 public TC4_Tab() {
	        PageFactory.initElements(driver, this);
	    }

	 //Click on lights
	 public void Light()
	 {
		
			        Actions action=new Actions(driver);
			        action.moveToElement(light).build().perform();
			       
			    }
	 
	 //click on ceilinig lights
	 public void Ceiling()
	 {
		 ceil.click();
	        System.out.println("Ceiling lights clicked ");
	        chandel.click();
	        System.out.println("Chandeliers clicked successfully ");

	 }
	 
	 //click on large chandeliers
	 public void large()
	 {
		 JavascriptExecutor javaScriptExecutor1 = (JavascriptExecutor)driver;
	      javaScriptExecutor1.executeScript("arguments[0].click()",large);
		// large.click();
	        System.out.println("Large Chandeliers clicked successfully ");
	        TakesScreenshot ts=(TakesScreenshot)driver;        
		    File source=ts.getScreenshotAs(OutputType.FILE);
		    try {
		        FileUtils.copyFile(source, new File("./screenshots/Large chandeliers page.png"));
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		    System.out.println("The screenshot is taken");

	 }
	 }
			    
	
