package testcases;

import java.util.concurrent.TimeUnit;

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
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageMethods.OrangeHRM.OrangeHRM_AdminPage;
import pageMethods.OrangeHRM.OrangeHRM_HomePage;
import pageMethods.OrangeHRM.OrangeHRM_Login_LogoutPage;
import pageMethods.OrangeHRM.OrangeHRM_PIMPage;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Utility;

@Listeners(utilities.Listeners.class)
public class TC_02_ChangePassword {
	
static WebDriver driver;
static SoftAssert assertion;
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
		assertion = new SoftAssert();

	}
	
	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void change_password() throws Exception {
		
		driver.get("https://testseleniumcod-trials72.orangehrmlive.com");
		Reporter.log("Orange HRM website is loaded", true);
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized", true);
		
		
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
		Reporter.log("Browser is closed");
		assertion.assertAll();
	}
}	
