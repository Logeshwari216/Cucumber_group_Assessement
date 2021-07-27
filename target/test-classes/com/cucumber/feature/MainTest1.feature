Feature: Title of your feature
  I want to use this template for my feature file

 Scenario: TC001 Account creation 
    Given Launch chrome browser
    When Launch website with valid url 
    And User click on My account 
    And user able to fill the details
    Then click on create account button user able to create an account successfully 
    
 Scenario: TC002 & TC003 Login and verify title
    
    Given Launch chrome browser
    When Launch website with valid url 
    And User click on My account 
    And User fill the details and able to login
    Then Verfiy the title
     
     
  Scenario: TC004 Tab
     Given Launch chrome browser
     When Launch website with valid url 
     And User click on My account 
     And User fill the details and able to login
     And click on lighting link
     And user able to click on ceiling lights and click chandeliers link
     And user able to click large chandeliers link and view that page
     
   Scenario: TC005 homePage
      Given Launch chrome browser
      When Launch website with valid url 
      And User click on My account 
      And User fill the details and able to login
      And click on lighting link
      And user able to click on ceiling lights and click chandeliers link
      And user able to click large chandeliers link and view that page
      And user able to apply the filter 
      Then user able to click on the product and view that page
      
      
      Scenario: TC0011 Remove product
      Given Launch chrome browser
      When Launch website with valid url 
      And User click on My account 
      And User fill the details and able to login
      And click on lighting link
      And user able to click on ceiling lights and click chandeliers link
      And user able to click large chandeliers link and view that page
      And user able to apply the filter 
      Then user able to click on the product and view that page
      And user able to add the product in the cart
      And user view the cart
      Then user able remove the product from the cart
      
      
     Scenario: TC17 Logout
    
     Given Launch chrome browser
     When Launch website with valid url 
     And User click on My account 
     And User fill the details and able to login
    Then user click on signout btn and able to signout 
      
  




  




