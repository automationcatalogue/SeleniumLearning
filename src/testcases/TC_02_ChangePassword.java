package testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
import pageMethods.OrangeHRM.OrangeHRM_AdminPage;
import pageMethods.OrangeHRM.OrangeHRM_HomePage;
import pageMethods.OrangeHRM.OrangeHRM_Login_LogoutPage;
import pageMethods.OrangeHRM.OrangeHRM_PIMPage;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.Utility;
@Listeners(utilities.Listeners.class)
public class TC_02_ChangePassword {
	
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
	
	@Test
	public void change_password() throws Exception {
		
		OrangeHRM_Login_LogoutPage.login("Admin", "Admin@123");
		
		OrangeHRM_HomePage.clickUsers();
		
		OrangeHRM_AdminPage.changePassword();
		
		OrangeHRM_Login_LogoutPage.logout();
		
	
		String newuserName=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_UserName, "OrangeHRM");
		String newpassword = ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Password, "OrangeHRM");
		
		OrangeHRM_Login_LogoutPage.login(newuserName, newpassword);
		
		OrangeHRM_Login_LogoutPage.logout();
		
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
		Log.info("Browser is closed");
		assertion.assertAll();
	}
}	
