package testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
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
import pageMethods.BaseClass;
import pageMethods.DemoWebShop.DemoWebShop_Login_LogoutPage;
import pageMethods.DemoWebShop.DemoWebShop_RegistrationPage;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.RandomGenerator;
import utilities.Utility;

public class TC_05_DemoWebShop_Register {
	
	static WebDriver driver;
	static SoftAssert assertion;
	static String excelPath;
	static String path;
	
	@BeforeClass
	public void setup() throws Exception {
		
		
		path=System.getProperty("user.dir");
		//DOMConfigurator.configure(path+"\\resources\\Log4j.xml");
		PropertyConfigurator.configure(path+"\\resources\\Log4j.properties");
		String className=Thread.currentThread().getStackTrace()[1].getClassName().substring(Thread.currentThread().getStackTrace()[1].getClassName().indexOf('.')+1);
		
		Log.startTestCase(className);
		Log.info("Path of the Project is :"+path);
		
		excelPath=path+"\\TestData\\TestData.xlsx";
		ExcelUtilities.setExcelFile(excelPath);
		assertion = new SoftAssert();
	
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public static void openBrowser(@Optional("Chrome") String browser) {
		Log.info("Browser Name from the TestNG.xml is :"+browser);
		driver=Utility.getDriver(browser);
		
		new BaseClass(driver);

		driver.get("http://demowebshop.tricentis.com");
		Log.info("Website is successfully loaded");

	}
	
	
	@Test
	public static void register() throws Exception {
		
		DemoWebShop_RegistrationPage.register(excelPath);
		
		DemoWebShop_Login_LogoutPage.logout();
  }
	@AfterClass
	public void teardown() {
		driver.quit();
		Log.info("Browser is closed");
		assertion.assertAll();
	}
}
