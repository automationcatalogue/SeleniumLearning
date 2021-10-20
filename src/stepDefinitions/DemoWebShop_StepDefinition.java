package stepDefinitions;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageMethods.BaseClass;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.RandomGenerator;
import utilities.Utility;

public class DemoWebShop_StepDefinition {
	
	static WebDriver driver;
	static String expectedDemoWebShopTitle="Demo Web Shop";
	
	@Given("^User navigates to the DemoWebShop website$")
	public void DemoWebShop_load()  throws Exception{
		String projectPath=System.getProperty("user.dir");
		PropertyConfigurator.configure(projectPath + "\\resources\\Log4j.properties");
		
		Log.info("Path of the Project is :"+projectPath);
		
		ExcelUtilities.setExcelFile(projectPath+"\\TestData\\TestData.xlsx");
		
		driver=Utility.getDriver("chrome");
				
		new BaseClass(driver);

		driver.get("http://demowebshop.tricentis.com");
		Log.info("Website is loaded");

	}
	
	@Then("^Validates the title of homepage$")
	public void vaidate_DemoWebShopTitle() {
		String sActualTitle=driver.getTitle();
		Assert.assertEquals(sActualTitle, expectedDemoWebShopTitle,"Title of the page is not matched");
	}
	
	@When("^User provides username and password and clicks on Login button$")
	public void login_DemoWebShop() {
		driver.findElement(By.className("ico-login")).click();
		Log.info("Login button is clicked");
		
		
		driver.findElement(By.id("Email")).sendKeys("aarosagarch@gmail.com");
		Log.info("Email Id is entered");
		
		driver.findElement(By.id("Password")).sendKeys("Admin@123");
		Log.info("Password is entered");
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Log.info("Login button is clicked");
		
	}
	
	@Then("^Register the User by providing all necessary information$")
	public void register_DemoWebShop() {
		BaseClass.getDriver().findElement(By.xpath("//a[text()='Register']")).click();
		Log.info("Register button is clicked");

		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		
		driver.findElement(By.name("FirstName")).sendKeys("sagar");		
		Log.info("First-name is entered");

		driver.findElement(By.id("LastName")).sendKeys("demowebshop");
		Log.info("Last name is entered");
				
		
		driver.findElement(By.id("Email")).sendKeys("sagar_demowebshop@gmail.com");
		Log.info("Email id is entered");

		BaseClass.getDriver().findElement(By.name("Password")).sendKeys("Admin@123");
		Log.info("password is entered");

		BaseClass.getDriver().findElement(By.id("ConfirmPassword")).sendKeys("Admin@123");
		Log.info("password entered in confirm password text-box");

		BaseClass.getDriver().findElement(By.id("register-button")).click();
		Log.info("Register button is selected");
	}
	
	@Then("^Validate whether user login successful or not$")
	public void validateLoginPage_DemoWebShop() {
		Log.info("Validated the Login page");
	}
}
