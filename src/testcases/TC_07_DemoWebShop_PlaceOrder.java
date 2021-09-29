package testcases;

import java.util.concurrent.TimeUnit;

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

import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Utility;

public class TC_07_DemoWebShop_PlaceOrder {
	static WebDriver driver;
	static SoftAssert assertion;
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
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
		//login
		driver.findElement(By.className("ico-login")).click();
		Reporter.log("Login button is clicked", true);
		
		String email=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Email, "DemoWebShop");
		driver.findElement(By.id("Email")).sendKeys(email);
		Reporter.log("Email Id is entered",true);
		
		String password=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Password, "DemoWebShop");
		driver.findElement(By.id("Password")).sendKeys(password);
		Reporter.log("Password is entered", true);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("Login button is clicked", true);
		
		//order
		driver.findElement(By.xpath("(//ul[@class='top-menu']/li/a)[1]")).click();
		Reporter.log("Selected Books from top menu",true);

		WebElement dropdown_menu = driver.findElement(By.id("products-orderby"));
		Select scategory = new Select(dropdown_menu);

		scategory.selectByIndex(0);
		Reporter.log("first option selected from the dropdown", true);

		scategory.selectByValue("http://demowebshop.tricentis.com/books?orderby=6");
		Reporter.log("Category Z to A slected from the dropdown", true);

		driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
		Reporter.log("Added item to the cart",true);
		
		//cart
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		Reporter.log("Selected shopping cart",true);

		WebElement element_country = driver.findElement(By.xpath("//select[@name='CountryId']"));
		Select s1category = new Select(element_country);

		s1category.selectByVisibleText("India");
		Reporter.log("India is selected from the country drop down", true);

		WebElement element_state = driver.findElement(By.xpath("//select[@name='StateProvinceId']"));
		Select s2category = new Select(element_state);

		s2category.selectByValue("0");
		Reporter.log("Other (Non US) selected from the state dropdown",true);

		driver.findElement(By.xpath("//input[@name='ZipPostalCode']")).clear();

		driver.findElement(By.xpath("//input[@name='ZipPostalCode']")).sendKeys("500020");
		Reporter.log("Entered pincode as 500060",true);

		WebElement element_chekbox = driver.findElement(By.id("termsofservice"));
		if (!element_chekbox.isSelected()) {
			element_chekbox.click();
			Reporter.log("Termsofservice Check-box is selected",true);
		} else {
			Reporter.log("Termsofservice Check-box is already selected",true);
		}

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Reporter.log("Checkout button is clicked",true);

		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
		Reporter.log("Continue button is selected for billing", true);

		driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
		Reporter.log("Continue button is selected for shipping",true);

		driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
		Reporter.log("Continue button is selected for shipping method",true);

		driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
		Reporter.log("Continue button is selected for payment method",true);

		driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
		Reporter.log("Continue button is selected for payment info",true);

		driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
		Reporter.log("Confirm button is clicked",true);

		String g = driver.findElement(By.xpath("//ul[@class='details']/li")).getText();
		Reporter.log(g, true);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		Reporter.log("Successfully logged out of the browser", true);

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
		Reporter.log("Browser is closed", true);
		assertion.assertAll();
	}
}