package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageMethods.DemoWebShop.DemoWebShop_Login_LogoutPage;
import pageMethods.DemoWebShop.DemoWebShop_RegistrationPage;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.RandomGenerator;
import utilities.Utility;

public class TC_05_DemoWebShop_Register {
	
	static WebDriver driver;
	static SoftAssert assertion;
	static String excelPath;
	
	@BeforeClass
	public void setup() throws Exception {
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		excelPath=path+"\\TestData\\TestData.xlsx";
		ExcelUtilities.setExcelFile(excelPath);
		assertion = new SoftAssert();
	
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public static void openBrowser(@Optional("Chrome") String browser) {
		Reporter.log("Browser Name from the TestNG.xml is :"+browser);
		driver=Utility.getDriver(browser);
				
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.get("http://demowebshop.tricentis.com");
		Reporter.log("Website is successfully loaded", true);

		driver.manage().window().maximize();
		Reporter.log("Browser window maximized", true);
	}
	
	
	@Test
	public static void register() throws Exception {
		
		DemoWebShop_RegistrationPage.register(excelPath);
		
		DemoWebShop_Login_LogoutPage.logout();
  }
	@AfterClass
	public void teardown() {
		driver.quit();
		Reporter.log("Browser is closed", true);
		assertion.assertAll();
	}
}
