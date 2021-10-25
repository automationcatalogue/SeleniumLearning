Feature: To Validate the OrangeHRM Scenarios

@Login @OrangeHRM
Scenario: OrangeHRM_Login
	Given User navigates to the OrangeHRM website
	Then Validates the title of homepage
	When User provides username and password and clicks on Login button
	Then Validate whether user login successful or not 
	Then User logsout from the website by clicking on the logout option
	
@AddEmployee @OrangeHRM
Scenario: OrangeHRM_AddEmployee
	Given User navigates to the OrangeHRM website
	Then Validates the title of homepage
	When User provides username and password and clicks on Login button
	Then User clicks on the add employee optionon the home page
	Then User navigates to the PIM page and performs all add employee actions
	Then User validates the employee details on PIM page 
	Then User logsout from the website by clicking on the logout option
	
@ChangePassword @OrangeHRM
Scenario: OrangeHRM_ChangePassword
	Given User navigates to the OrangeHRM website
	Then Validates the title of homepage
	When User provides username and password and clicks on Login button
	Then User navigates through the UserManagement and clicks on the users option
	Then User selects edit user and performs change password actions
	Then User logsout from the website by clicking on the logout option
	When User provides username and cahnged password and clicks on Login button to validate if login is successful
	Then User logsout from the website by clicking on the logout option
	