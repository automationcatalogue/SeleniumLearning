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