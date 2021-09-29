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

import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Utility;


public class TC_06_DemoWebShop_Login {
	
	static WebDriver driver;
	static SoftAssert assertion;
	
	@BeforeClass
	public static void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
		assertion= new SoftAssert();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public static void openBrowser(@Optional("Chrome") String browser) {
		Reporter.log("Browser Name from the TestNG.xml is :"+browser , true);
		driver=Utility.getDriver(browser);
				
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.get("http://demowebshop.tricentis.com");
		Reporter.log("Website is loaded", true);

		driver.manage().window().maximize();
		Reporter.log("Browser window maximized", true);
	}
	
	@Test(dataProviderClass = utilities.DataProvider_DemoWebShop_Login.class, dataProvider = "LoginData1") 
	public static void login_DemoWebShop_DataProvider(String email, String password) throws Exception{
		
		
		driver.findElement(By.className("ico-login")).click();
		Reporter.log("Login button is clicked", true);
		
		
		driver.findElement(By.id("Email")).sendKeys(email);
		Reporter.log("Email Id is entered",true);
		
		driver.findElement(By.id("Password")).sendKeys(password);
		Reporter.log("Password is entered", true);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("Login button is clicked", true);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		Reporter.log("Successfully logged out of the browser", true);
  }
	
	
	@AfterMethod
	public void afterClass() {
		driver.quit();
		Reporter.log("Browser is closed", true);
		assertion.assertAll();
	}
}
