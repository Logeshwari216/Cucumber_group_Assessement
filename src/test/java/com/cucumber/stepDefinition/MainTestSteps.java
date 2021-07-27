package com.cucumber.stepDefinition;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.cucumber.base.TestBase;
import com.cucumber.data.ReadExcelFile;
import com.cucumber.pages.TC11_RemoveProduct;
import com.cucumber.pages.TC17_Logout;
import com.cucumber.pages.TC1_AccountCreation;
import com.cucumber.pages.TC2_Login;
import com.cucumber.pages.TC4_Tab;
import com.cucumber.pages.TC5_HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainTestSteps extends TestBase{
	
	TestBase base;
	TC1_AccountCreation page;
	TC2_Login loginpage;
	TC4_Tab tabpage;
	TC5_HomePage homepage;
	TC17_Logout logoutpage;
	TC11_RemoveProduct removeprd;
	
	
	/*********************ACCOUNT cREATION************/
	
	@Given("^Launch chrome browser$")	
	public void launch_chrome_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		base = new TestBase();
		   base.launchBrowser();
	}
	@When("^Launch website with valid url$")
	public void launch_website_with_valid_url() throws Throwable {
		base = new TestBase();
		   base.launchURL();
		}

	
	@When("^User click on My account$")
	public void user_click_on_My_account() throws Throwable {
		 page=new TC1_AccountCreation();
		 page.myaccount();

	}

	@When("^user able to fill the details$")
	public void user_click_on_create_account_and_fill_the_details_in_sheetname_and_rownumber_and_able_to_login() throws Throwable {
		 page=new TC1_AccountCreation();
		 ReadExcelFile reader = new ReadExcelFile();
			ArrayList<String> testdata=reader.getData("user1");

			page.detail(testdata.get(1), testdata.get(2),testdata.get(3),testdata.get(3),testdata.get(4),testdata.get(4));
			
		
	}

	@Then("^click on create account button user able to create an account successfully$")
	public void click_on_create_account_button_user_able_to_create_an_account_successfully() throws Throwable {
		 page=new TC1_AccountCreation();
page.createaccount();
	}

	/*********************Login and verify the title************/

	@When("^User fill the details and able to login$")
	public void User_fill_the_details_and_able_to_login() throws Throwable {
		
		 loginpage=new TC2_Login();
		 
		 ReadExcelFile reader = new ReadExcelFile();
			ArrayList<String> testdata=reader.getData("user1");

			loginpage.login(testdata.get(3), testdata.get(4));
			 
			
	}
	@Then("^Verfiy the title$")
	public void Verfiy_the_title() throws Throwable {
		
		 loginpage=new TC2_Login();
		 String pageTitle=loginpage.verifyHomePageTitle();
	        Assert.assertEquals("Modern Lighting, Ceiling Fans, Furniture & Home Decor | Lumens.com", pageTitle);
	        System.out.println("Title verfied Successfully");

	}
	
	/*********************Tabs************/

	@When("^click on lighting link$")
	public void click_on_lighting_link() throws Throwable {
		 tabpage=new TC4_Tab() ;
		 tabpage.Light();

	}

	@When("^user able to click on ceiling lights and click chandeliers link$")
	public void user_able_to_click_on_ceiling_lights_and_click_chandeliers_link() throws Throwable {
		 tabpage=new TC4_Tab() ;
		 tabpage.Ceiling();
	}

	@When("^user able to click large chandeliers link and view that page$")
	public void user_able_to_click_large_chandeliers_link_and_view_that_page() throws Throwable {
		 tabpage=new TC4_Tab() ;
		 tabpage.large();

	}
	
	/*********************Select product and apply filter************/

	@When("^user able to apply the filter$")
	public void user_able_to_apply_the_filter() throws Throwable {
		 homepage=new TC5_HomePage();
		 homepage.filter();

	}

	@Then("^user able to click on the product and view that page$")
	public void user_able_to_click_on_the_product_and_view_that_page() throws Throwable {
		 homepage=new TC5_HomePage();
		 homepage.product();
	}
	
	/*********************Logout ************/


	@Then("^user click on signout btn and able to signout$")
	public void user_click_on_signout_btn_and_able_to_signout() throws Throwable {
		 logoutpage=new TC17_Logout() ;
		 logoutpage.signout();

	}
	
	/********************* Remove Product*******************/
	
	@Then("^user able to add the product in the cart$")
	public void user_able_to_add_the_product_in_the_cart() throws Throwable {
		 removeprd=new TC11_RemoveProduct();
		 removeprd.add();

	}

	@Then("^user view the cart$")
	public void user_view_the_cart() throws Throwable {
		 removeprd=new TC11_RemoveProduct();
		 removeprd.view();
	}

	@Then("^user able remove the product from the cart$")
	public void user_able_remove_the_product_from_the_cart() throws Throwable {
		 removeprd=new TC11_RemoveProduct();
		 removeprd.remove();
	}




}

