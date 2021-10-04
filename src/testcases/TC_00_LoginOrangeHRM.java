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

import pageMethods.OrangeHRM.OrangeHRM_Login_LogoutPage;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.Utility;


public class TC_00_LoginOrangeHRM {
	
	static WebDriver driver;
	static SoftAssert assertion;
	
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Log.info("Path of the Project is :"+path);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
		assertion = new SoftAssert();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openBrowser(@Optional("Chrome") String browser) {
		Log.info("Browser Name from the TestNG.xml is :"+browser);
		driver=Utility.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Parameters({"username","password"})
	@Test(enabled = true)
	public void login_OrangeHRM_Parameterization(@Optional("Admin")String username, @Optional("Admin@123")String password) throws Exception {
		
		
		driver.get("https://testseleniumcod-trials72.orangehrmlive.com");
		Log.info("Orange HRM website is loaded");
		driver.manage().window().maximize();
		Log.info("Browser window is maximized");
		
	
		OrangeHRM_Login_LogoutPage.login(username, password);
		

	}
	
	@Test(dataProviderClass = utilities.DataProviders.class, dataProvider = "OrangeHRMLoginData", enabled=true) 
	public void login_OrangeHRM_DataProvider(String username, String password) throws Exception {
		
		
		driver.get("https://testseleniumcod-trials72.orangehrmlive.com");
		Log.info("Orange HRM website is loaded");
		driver.manage().window().maximize();
		Log.info("Browser window is maximized");
		
	
		OrangeHRM_Login_LogoutPage.login(username, password);
		
		OrangeHRM_Login_LogoutPage.logout();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		Log.info("Browser is closed");
		assertion.assertAll();
	}
}


