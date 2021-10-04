package testcases;


import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageMethods.DemoWebShop.DemoWebShop_Login_LogoutPage;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.Utility;


public class TC_06_DemoWebShop_Login {
	
	static WebDriver driver;
	static SoftAssert assertion;
	
	@BeforeClass
	public static void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Log.info("Path of the Project is :"+path);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
		assertion= new SoftAssert();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public static void openBrowser(@Optional("Chrome") String browser) {
		Log.info("Browser Name from the TestNG.xml is :"+browser );
		driver=Utility.getDriver(browser);
				
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.get("http://demowebshop.tricentis.com");
		Log.info("Website is loaded");

		driver.manage().window().maximize();
		Log.info("Browser window maximized");
	}
	
	@Test(dataProviderClass = utilities.DataProviders.class, dataProvider = "DemoWebShopLoginData") 
	public static void login_DemoWebShop_DataProvider(String email, String password) throws Exception{
		
		DemoWebShop_Login_LogoutPage.login(email, password);
		
		DemoWebShop_Login_LogoutPage.logout();
  }
	
	
	@AfterMethod
	public void afterClass() {
		driver.quit();
		Log.info("Browser is closed");
		assertion.assertAll();
	}
}
