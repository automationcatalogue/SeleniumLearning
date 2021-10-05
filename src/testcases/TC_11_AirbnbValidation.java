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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageMethods.BaseClass;
import pageMethods.airbnb.AirbnbFilterPage;
import pageMethods.airbnb.AirbnbHomePage;
import utilities.Log;
import utilities.Utility;

public class TC_11_AirbnbValidation {
	
	static WebDriver driver;
	static SoftAssert assertion;
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Log.info("Path of the Project is :"+path);
	
		assertion = new SoftAssert();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openBrowser(@Optional("Chrome") String browser) {
		Log.info("Browser Name from the TestNG.xml is :"+browser);
		driver=Utility.getDriver(browser);
		
		new BaseClass(driver);
		
		driver.get("https://www.airbnb.co.in/?locale=en&_set_bev_on_new_domain=1626060086_MDkyYzhmZTgxNzlh");
		Log.info("Airbnb website is loaded");
	}
	
	@Test
	public void priceRangeFilter() throws Exception {

		
		AirbnbHomePage.openFilterWindow();
		
		//filters
		AirbnbFilterPage.allActionsInFilterWindow();
		
		
	}
	
	@AfterClass
	public void close_browser() {
		driver.quit();
		assertion.assertAll();
	}
	
}
