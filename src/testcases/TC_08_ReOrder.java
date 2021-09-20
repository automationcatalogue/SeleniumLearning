package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Constant;
import utilities.ExcelUtilities;

public class TC_08_ReOrder {
	 
static WebDriver driver;
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
	}
	
	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://demowebshop.tricentis.com");
		Reporter.log("Website loaded");

		driver.manage().window().maximize();
		Reporter.log("Browser window maximized");
	}
	
	@Test
	
	public void re_Order() throws Exception{
		
		driver.findElement(By.className("ico-login")).click();
		Reporter.log("Login button is clicked", true);
		
		String email=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Email, "DemoWebShop");
		
		driver.findElement(By.id("Email")).sendKeys(email);
		Reporter.log("Email Id is entered",true);
		
		String password=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Password, "DemoWebShop");
		driver.findElement(By.id("Password")).sendKeys(password);
		Reporter.log("Entered password", true);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("clicked on Login button", true);
		
		driver.findElement(By.xpath("//a[text()='aarosagarch@gmail.com']")).click();
		Reporter.log("Clicked on email name", true);
		
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
         
         driver.findElement(By.xpath("//input[@class='button-1 re-order-button']")).click();
    	 Reporter.log("Re-Order button is clicked",true);
    	 
    	 driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
    	 Reporter.log("Terms of service check-box is checked", true);
    	 
    	 driver.findElement(By.xpath("//button[@id='checkout']")).click();
    	 Reporter.log("Checkout button is clicked", true);
    	 
    	 driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
    	 Reporter.log("Continue button is clicked agter saving billing information", true);
    	             	
    	 driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
    	 Reporter.log("Continue button is clicked", true);
    	 
    	 Actions radio_btn= new Actions(driver);
    	 
    	 WebElement shipping_method= driver.findElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedRate']"));
    	 
    	 radio_btn.click(shipping_method).build().perform();
    	 Reporter.log("Shipping method radio button is selected",true);            	 
    	 
    	 driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
    	 Reporter.log("Continue button clicked after selecting shipping method", true);
    	 
    	 driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
    	 Reporter.log("Continue buton clicked after selecting payment method",true);
    	 
    	 driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
    	 Reporter.log("Contine button clicked to save payment information", true);
    	 
    	 driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
    	 Reporter.log("Confirm button is clicked to confirm order", true);
    	 
    	String order_confirmation= driver.findElement(By.xpath("//ul[@class='details']/li[1]")).getText();
    	Reporter.log(order_confirmation,true);
	}
}
