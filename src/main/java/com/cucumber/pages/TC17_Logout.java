package com.cucumber.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.TestBase;

public class TC17_Logout extends TestBase {

	@FindBy(xpath = "//span[text()='Account']")
	WebElement account;
	@FindBy(xpath = "//a[text()='Sign Out']")
	WebElement signout;

	public TC17_Logout() {
		PageFactory.initElements(driver, this);
	}

	//click on logout button 
	public void signout() {
		Actions action = new Actions(driver);
		action.moveToElement(account).build().perform();
		
		System.out.println("Mouseover action moved successfully");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		Actions action1 = new Actions(driver);
		action1.moveToElement(signout).build().perform();
		
		System.out.println("Logout successfully");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

	}

}
