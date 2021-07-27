package com.cucumber.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.TestBase;



public class TC1_AccountCreation extends TestBase{
	
	@FindBy(xpath="//a[@class='ltkpopup-close']") WebElement close;
	@FindBy(xpath="//div[@class=\'btn-group dropdown-group\']//i[@class=\'lu-sprite\']") WebElement acc;
	@FindBy(linkText="My Account") WebElement myacc;
	@FindBy(xpath="//input[@id='dwfrm_profile_customer_firstname']") WebElement fname;
	@FindBy(xpath="//input[@id='dwfrm_profile_customer_lastname']") WebElement lname;
	@FindBy(xpath="//input[@id='dwfrm_profile_customer_email']") WebElement email;
	@FindBy(xpath="//input[@id='dwfrm_profile_customer_emailconfirm']") WebElement emailcon;
	@FindBy(xpath="//input[@id='dwfrm_profile_login_password']") WebElement pass;
	@FindBy(xpath="//input[@id='dwfrm_profile_login_passwordconfirm']") WebElement passcon;
	@FindBy(xpath="//span[text()='Create Account']") WebElement create;
	
	public TC1_AccountCreation() {
        PageFactory.initElements(driver, this);
    }
	
	//click on myaccount
	public void myaccount()
	{
		close.click();
		acc.click();
		myacc.click();
		
	}
	
	//fill all the details 
	public void detail(String firstname,String lastname,String emailid,String confime,String password,String cofirmpass)
	{
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		email.sendKeys(emailid);
		emailcon.sendKeys(confime);
		pass.sendKeys(password);
		passcon.sendKeys(cofirmpass);
	}
	
	//click on create btn and account created successfully
	public void createaccount()
	{
		create.click();
		System.out.println("Account created Successfully");
		TakesScreenshot ts=(TakesScreenshot)driver;        
	    File source=ts.getScreenshotAs(OutputType.FILE);
	    try {
	        FileUtils.copyFile(source, new File("./screenshots/AccountCreation.png"));
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    System.out.println("The screenshot is taken");
	}
}
