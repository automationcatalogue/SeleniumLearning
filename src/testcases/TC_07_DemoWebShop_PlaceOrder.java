package testcases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageMethods.BaseClass;
import pageMethods.DemoWebShop.DemoWebShop_BrowsePage;
import pageMethods.DemoWebShop.DemoWebShop_CheckoutPage;
import pageMethods.DemoWebShop.DemoWebShop_HomePage;
import pageMethods.DemoWebShop.DemoWebShop_Login_LogoutPage;
import pageMethods.DemoWebShop.DemoWebShop_ShoppingBag;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.Utility;

@Listeners (utilities.Listeners.class)
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
		Utility.setClassName(className);
		Log.startTestCase(className);
		
		Log.info("Path of the Project is :"+path);
		
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
		assertion = new SoftAssert();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public static void openBrowser(@Optional("Chrome") String browser) {
		Log.info("Browser Name from the TestNG.xml is :"+browser);
		driver=Utility.getDriver(browser);
		
		new BaseClass(driver);

		driver.get("http://demowebshop.tricentis.com");
		Log.info("Website is loaded");

	}
		
	@Test
	public void placeOrder_DemoWebshop() throws Exception {
		
		
		DemoWebShop_Login_LogoutPage.login("aarosagarch@gmail.com", "Admin@12345");
		Reporter.log("DemoWebShop Login is successful", true);
		
		DemoWebShop_HomePage.selectBooksCategory();
		Reporter.log("Selected the Books Category", true);

		DemoWebShop_BrowsePage.addItemIntoCart();
		Reporter.log("Items are added into the Cart", true);

		DemoWebShop_ShoppingBag.allShoppingBagActions();
		Reporter.log("All Shopping Bag actions are performed", true);

		DemoWebShop_CheckoutPage.allCheckoutActions();
		Reporter.log("All Checkout page actions are performed", true);
		
		DemoWebShop_Login_LogoutPage.logout();
		Reporter.log("Logout is Successful");

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
		Log.info("Browser is closed");
		assertion.assertAll();
		Log.endTestCase();
		
	}
}