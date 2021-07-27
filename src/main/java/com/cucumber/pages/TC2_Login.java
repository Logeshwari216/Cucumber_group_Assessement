package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.TestBase;

public class TC2_Login extends TestBase{

	    @FindBy(id="dwfrm_login_username")
	    WebElement email;
	    
	    @FindBy(id="dwfrm_login_password")
	    WebElement password;
	    
	    @FindBy(xpath="//button[@name='dwfrm_login_login']")
	    WebElement loginButton;
	    
	    public TC2_Login() {
	        PageFactory.initElements(driver, this);
	    }
	  
	   //Login function
	    
	    public void login(String emailId, String passWord) {
	    	
	        
	       
	        email.sendKeys(emailId);
	        password.sendKeys(passWord);
	        loginButton.click();
	        System.out.println("Login Successfully");
	    }
	    
	    //verify the title
  public String verifyHomePageTitle() {
	        
	        return driver.getTitle();
	    }
	    
	

}
