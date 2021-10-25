Feature: To Validate the DemoWebShop Scenarios

@Login @DemoWebShop
Scenario: DemoWebShop_Login
	Given User navigates to the DemoWebShop website
	Then Validates the title of homepage
	When User provides username and password and clicks on Login button
	Then Validate whether user login successful or not 

@Register @DemoWebShop
Scenario: DemoWebShop_Registration
	Given User navigates to the DemoWebShop website
	Then Validates the title of homepage
	Then Register the User by providing all necessary information
	
@PlaceOredr @DemoWebShop
Scenario: DemoWebShop_PlaceOrder
	Given User navigates to the DemoWebShop website
	Then Validates the title of homepage		
	When User provides username and password and clicks on Login button
	Then User clicks on Home page menu item books category
	Then Adds item into the cart
	Then User Performs all shopping bag actions
	Then User clicks checkout button and performs all checkout actions
	Then User logsout from the website by clicking on the logout option
		
@Reorder @DemoWebShop
Scenario: DemmoWebShop_ReOrder
	Given User navigates to the DemoWebShop website
	Then Validates the title of homepage
	When User provides username and password and clicks on Login button
	Then User clicks on Orders in CustomerInfoPage
	Then User selects a specific order 
	Then User selects the reorder option
	Then User Performs all shopping bag actions
	Then User clicks checkout button and performs all checkout actions
	Then User logout from the website by clicking on the logout option
		
@AllOrdersTotal  @DemoWebShop
Scenario: DemmoWebShop_AllOrdersTotal
	Given User navigates to the DemoWebShop website
	Then Validates the title of homepage
	When User provides username and password and clicks on Login button
	Then User clicks on Orders in CustomerInfoPage
	Then User retrieves total number of orders placed from orders page
	Then User gets sum of all orders total from orders page
	Then User retrieves sum of all orders total datewise from orders page
	Then User logout from the website by clicking on the logout option