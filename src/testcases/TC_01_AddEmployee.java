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
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageMethods.BaseClass;
import pageMethods.OrangeHRM.OrangeHRM_HomePage;
import pageMethods.OrangeHRM.OrangeHRM_Login_LogoutPage;
import pageMethods.OrangeHRM.OrangeHRM_PIMPage;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.RandomGenerator;
import utilities.Utility;

@Listeners(utilities.Listeners.class)
public class TC_01_AddEmployee{
	
	static WebDriver driver;
	static SoftAssert assertion;
	static String excelPath;
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		excelPath=path+"\\TestData\\TestData.xlsx";
		ExcelUtilities.setExcelFile(excelPath);
		assertion = new SoftAssert();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openBrowser(@Optional("Chrome") String browser) {
		Reporter.log("Browser Name from the TestNG.xml is :"+browser);
		driver=Utility.getDriver(browser);
		new BaseClass(driver);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void add_Employee() throws Exception {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		driver.get("https://testseleniumcod-trials72.orangehrmlive.com");
		Reporter.log("Orange HRM website is loaded", true);
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized", true);
		
		
		OrangeHRM_Login_LogoutPage.login("Admin", "Admin@123");
		
		OrangeHRM_HomePage.clickAddEmployee();
		
		OrangeHRM_PIMPage.allAddEmployeeActions(excelPath);
		
		OrangeHRM_PIMPage.verifyEmployeeDetails();
		
		OrangeHRM_Login_LogoutPage.logout();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("Browser is closed", true);
		//assertion.assertAll();
	}
}


