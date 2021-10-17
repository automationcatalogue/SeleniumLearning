package testcases;

import java.util.ArrayList;
import java.util.List;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageMethods.BaseClass;
import pageMethods.DemoWebShop.DemoWebShop_CustomerInfoPage;
import pageMethods.DemoWebShop.DemoWebShop_Login_LogoutPage;
import pageMethods.DemoWebShop.DemoWebShop_OrdersPage;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.Utility;
@Listeners(utilities.Listeners.class)
public class TC_09_AllOrdersTotal {

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
		
		driver.get("http://demowebshop.tricentis.com");
		Log.info("Website is successfully loaded");
		
	}
	
	@Test
	
	public void allorders_total() throws Exception{
		
		DemoWebShop_Login_LogoutPage.login("aarosagarch@gmail.com", "Admin@123");
		
		DemoWebShop_CustomerInfoPage.clickOrders();
		
		DemoWebShop_OrdersPage.getNumberOfOrders();
		
		DemoWebShop_OrdersPage.getSumOfAllOrdersTotal();
		
		DemoWebShop_OrdersPage.getSumOfAllOrdersTotal_DateWise();
		
	}
	@AfterClass
	public void close_browser() {
		driver.quit();
		Log.info("Browser is successfully closed");
		assertion.assertAll();
  }
}
	
