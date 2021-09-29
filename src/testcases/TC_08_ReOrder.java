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
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Utility;

public class TC_08_ReOrder {
	 
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
	public void openBrowser(@Optional("Chrome") String browser) {
		Reporter.log("Browser Name from the TestNG.xml is :"+browser, true);
		driver=Utility.getDriver(browser);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://demowebshop.tricentis.com");
		Reporter.log("Website is successfully loaded", true);

		driver.manage().window().maximize();
		Reporter.log("Browser window maximized", true);
	}
	
	@Test
	
	public void re_Order() throws Exception{
		
		driver.findElement(By.className("ico-login")).click();
		Reporter.log("Login button is clicked", true);
		
		//login
		String email=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Email, "DemoWebShop");
		driver.findElement(By.id("Email")).sendKeys(email);
		Reporter.log("Email Id is entered",true);
		
		String password=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Password, "DemoWebShop");
		driver.findElement(By.id("Password")).sendKeys(password);
		Reporter.log("Password is entered", true);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("Login button is clicked", true);
		
		driver.findElement(By.xpath("//a[text()='aarosagarch@gmail.com']")).click();
		Reporter.log("Email name is clicked", true);
		
		//orders
		driver.findElement(By.xpath("//ul[@class='list']/li[3]/a")).click();
		Reporter.log("Orders selcted from the options", true);
		
		List<WebElement> orders = driver.findElements(By.xpath("//div[@class='order-list']/div/div[1]")); 
         for(int i=1;i<=orders.size();i++){
            
        	 System.out.print(orders.get(i));
        	 System.out.println();
        	 
        	 //String order_number=orders.get(i).findElement(By.xpath("//div[@class='title']//strong[contains(text(),'Order Number')]")).getText();
        	 String order_number=orders.get(i).getText();

        	 Reporter.log(order_number, true);
        	 
        	 String Order_Num=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_orderno, "DemoWebShop");

             if(order_number.contains(Order_Num)){

            	 orders.get(i).findElement(By.xpath(".//following-sibling::div/input")).click();
            	 Reporter.log("Order details button is clicked", true);
            	 break;        	 
             }
         }
         
         //reorder
         driver.findElement(By.xpath("//input[@class='button-1 re-order-button']")).click();
    	 Reporter.log("Re-Order button is clicked",true);
    	 
    	 driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
    	 Reporter.log("Terms of service check-box is clicked", true);
    	 
    	 driver.findElement(By.xpath("//button[@id='checkout']")).click();
    	 Reporter.log("Checkout button is clicked", true);
    	 
    	 driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
    	 Reporter.log("Continue button is clicked after saving billing information", true);
    	             	
    	 driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
    	 Reporter.log("Continue button is clicked", true);
    	 
    	 Actions radio_btn= new Actions(driver);
    	 
    	 WebElement shipping_method= driver.findElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedRate']"));
    	 radio_btn.click(shipping_method).build().perform();
    	 Reporter.log("Shipping method radio button is clicked",true);            	 
    	 
    	 driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
    	 Reporter.log("Continue button clicked after selecting shipping method", true);
    	 
    	 driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
    	 Reporter.log("Continue buton is clicked after selecting payment method",true);
    	 
    	 driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
    	 Reporter.log("Contine button is clicked to save payment information", true);
    	 
    	 driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
    	 Reporter.log("Confirm button is clicked to confirm order", true);
    	 
    	String order_confirmation= driver.findElement(By.xpath("//ul[@class='details']/li[1]")).getText();
    	Reporter.log(order_confirmation,true);
    	
    	Thread.sleep(3000);		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		Reporter.log("Successfully logged out of the browser", true);
	}
	
	@AfterClass
	public void close_browser() {
		driver.quit();
		Reporter.log("Browser is successfully closed", true);
		assertion.assertAll();
	}
}
