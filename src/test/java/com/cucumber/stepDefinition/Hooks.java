package com.cucumber.stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.cucumber.base.TestBase;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks extends TestBase {

 public static String screenshotpath;
	 
	 @After
	 public void captureScreenShot(Scenario scenario) {
		 
		 if(scenario.isFailed()) {
			 String screenshotName = scenario.getName().replaceAll(" ", "_");		 
				
			 try {	 
		 //This takes a screenshot from the driver at save it to the specified location
		 File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		 //Create unique file name and store in under screenshot folder of root directory
         screenshotpath = System.getProperty("user.dir")+"\\target\\ScreenShots\\Failed" +screenshotName + ".png";
         
         //Copy the file to destination
         FileHandler.copy(sourcePath, new File(screenshotpath));
         System.out.println(scenario+" failed");  
	 
	 //This attach the specified screenshot to the test
	 Reporter.addScreenCaptureFromPath(screenshotpath.toString());
	 } catch (IOException e) {
	 } 
	 }
	 }
	 @After
	  public void closeBrowser() {
			driver.manage().timeouts().implicitlyWait(50000000, TimeUnit.SECONDS);

	        driver.quit();
	    }

	
}
