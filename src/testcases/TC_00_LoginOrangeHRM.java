package testcases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageMethods.BaseClass;
import pageMethods.OrangeHRM.OrangeHRM_Login_LogoutPage;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.Utility;
/**
 * 
 * This Testcase is related to the OrangeHRM Login
 *
 */
@Listeners(utilities.Listeners.class)
public class TC_00_LoginOrangeHRM {
	
	static WebDriver driver;
	static SoftAssert assertion;
	static String path;
	
	@BeforeClass
	public void setup() throws Exception{
		 path=System.getProperty("user.dir");
		PropertyConfigurator.configure(path+"\\resources\\Log4j.properties");
		
		String className=Thread.currentThread().getStackTrace()[1].getClassName().substring(Thread.currentThread().getStackTrace()[1].getClassName().indexOf('.')+1);
		Utility.setClassName(className);
		Log.startTestCase(className);
		Log.info("Path of the Project is :"+path);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
		assertion = new SoftAssert();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openBrowser(@Optional("Chrome") String browser) {
		Log.info("Browser Name from the TestNG.xml is :"+browser);
		driver=Utility.getDriver(browser);
		
		new BaseClass(driver);
		
		driver.get("https://catalogue-trials72.orangehrmlive.com/");
		Log.info("Orange HRM website is loaded");
	}
	
	@Parameters({"username","password"})
	@Test(enabled = true)
	public void login_OrangeHRM_Parameterization(@Optional("Admin")String username, @Optional("Admin@123")String password) throws Exception {
	
		OrangeHRM_Login_LogoutPage.login(username, password);
		

	}
	
	@Test(dataProviderClass = utilities.DataProviders.class, dataProvider = "OrangeHRMLoginData", enabled=true) 
	public void login_OrangeHRM_DataProvider(String username, String password) throws Exception {
		Reporter.log("UserName is :"+username+" Password is :"+password);
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


