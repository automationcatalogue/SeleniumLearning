package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
import pageMethods.DemoWebShop.DemoWebShop_CheckoutPage;
import pageMethods.DemoWebShop.DemoWebShop_CustomerInfoPage;
import pageMethods.DemoWebShop.DemoWebShop_Login_LogoutPage;
import pageMethods.DemoWebShop.DemoWebShop_OrdersPage;
import pageMethods.DemoWebShop.DemoWebShop_ShoppingBag;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.Utility;
@Listeners(utilities.Listeners.class)
public class TC_08_ReOrder {
	 
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
		
		new BaseClass(driver);
		
		driver.get("http://demowebshop.tricentis.com");
		Log.info("Website is successfully loaded");
	}
	
	@Test
	
	public void re_Order() throws Exception{
		
		DemoWebShop_Login_LogoutPage.login("aarosagarch@gmail.com", "Admin@123");
		
		DemoWebShop_CustomerInfoPage.clickOrders();
		
		DemoWebShop_OrdersPage.selectSpecificOrder();
         
		DemoWebShop_OrdersPage.reOrder();
        
    	DemoWebShop_ShoppingBag.reOrder_ShoppingBagAction();
    	 
    	DemoWebShop_CheckoutPage.reOrder_CheckoutAction();
    	
    	DemoWebShop_Login_LogoutPage.logout();
	}
	
	@AfterClass
	public void close_browser() {
		driver.quit();
		Log.info("Browser is successfully closed");
		assertion.assertAll();
	}
}
