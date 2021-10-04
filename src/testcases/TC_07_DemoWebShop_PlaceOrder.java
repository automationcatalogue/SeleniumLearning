package testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageMethods.DemoWebShop.DemoWebShop_BrowsePage;
import pageMethods.DemoWebShop.DemoWebShop_CheckoutPage;
import pageMethods.DemoWebShop.DemoWebShop_HomePage;
import pageMethods.DemoWebShop.DemoWebShop_Login_LogoutPage;
import pageMethods.DemoWebShop.DemoWebShop_ShoppingBag;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.Utility;

public class TC_07_DemoWebShop_PlaceOrder {
	static WebDriver driver;
	static SoftAssert assertion;
	static String path;
	
	@BeforeClass
	public void setup() throws Exception{
		
		
		path=System.getProperty("user.dir");
		//DOMConfigurator.configure(path+"\\resources\\Log4j.xml");
		PropertyConfigurator.configure(path+"\\resources\\Log4j.properties");
		
		
		String className=Thread.currentThread().getStackTrace()[1].getClassName().substring(Thread.currentThread().getStackTrace()[1].getClassName().indexOf('.')+1);
		
		Log.startTestCase(className);
		Log.info("Path of the Project is :"+path);
		
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
		assertion = new SoftAssert();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public static void openBrowser(@Optional("Chrome") String browser) {
		Reporter.log("Browser Name from the TestNG.xml is :"+browser, true);
		driver=Utility.getDriver(browser);
				
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.get("http://demowebshop.tricentis.com");
		Reporter.log("Website is loaded", true);

		driver.manage().window().maximize();
		Reporter.log("Browser window maximized", true);
	}
		
	@Test
	public void placeOrder_DemoWebshop() throws Exception {
		
		
		DemoWebShop_Login_LogoutPage.login("aarosagarch@gmail.com", "Admin@123");
		
		DemoWebShop_HomePage.selectBooksCategory();

		DemoWebShop_BrowsePage.addItemIntoCart();

		DemoWebShop_ShoppingBag.allShoppingBagActions();

		DemoWebShop_CheckoutPage.allCheckoutActions();
		
		DemoWebShop_Login_LogoutPage.logout();

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
		Log.info("Browser is closed");
		assertion.assertAll();
		Log.endTestCase();
		
	}
}