package testcases;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Utility;


public class TC_00_LoginOrangeHRM {
	
	static WebDriver driver;
	static SoftAssert assertion;
	
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
		assertion = new SoftAssert();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openBrowser(@Optional("Chrome") String browser) {
		Reporter.log("Browser Name from the TestNG.xml is :"+browser);
		driver=Utility.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Parameters({"username","password"})
	@Test(enabled = true)
	public void login_OrangeHRM_Parameterization(@Optional("Admin")String username, @Optional("Admin@123")String password) throws Exception {
		
		
		driver.get("https://testseleniumcod-trials72.orangehrmlive.com");
		Reporter.log("Orange HRM website is loaded", true);
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized", true);
		
	
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		Reporter.log(username+" is entered as UserName in a text-box", true);
		
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		Reporter.log(password+" is entered as Password in a text-box", true);
		
		driver.findElement(By.id("btnLogin")).click();
		Reporter.log("Login button is clicked",true);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[text()='Dashboard']")).isDisplayed());
		Reporter.log("Home page is displayed", true);
		

	}
	
	@Test(dataProviderClass = utilities.DataProviders.class, dataProvider = "LoginData", enabled=true) 
	public void login_OrangeHRM_DataProvider(String username, String password) throws Exception {
		
		
		driver.get("https://testseleniumcod-trials72.orangehrmlive.com");
		Reporter.log("Orange HRM website is loaded", true);
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized", true);
		
	
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		Reporter.log(username+" is entered as UserName in a text-box", true);
		
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		Reporter.log(password+" is entered as Password in a text-box", true);
		
		driver.findElement(By.id("btnLogin")).click();
		Reporter.log("Login button is clicked",true);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[text()='Dashboard']")).isDisplayed());
		Reporter.log("Home page is displayed", true);
		
		WebElement dropdown_logout = driver.findElement(By.xpath("//i[text()='keyboard_arrow_down']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",dropdown_logout);
		Reporter.log("Logout dropdown is clicked", true);
		
		WebElement element_logoutBtn=driver.findElement(By.xpath("//ul[@id='user_menu']//li[3]/a"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_logoutBtn);
		Reporter.log("Successfully logged out of the browser", true);
		
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		Reporter.log("Browser is closed", true);
		assertion.assertAll();
	}
}


