package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import pageMethods.BaseClass;
import utilities.Log;

public class DemoWebShop_CheckoutPage {
	static WebDriver driver=BaseClass.getDriver();
	
	public static void allCheckoutActions() {
		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
		Log.info("Continue button is selected for billing");

		driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
		Log.info("Continue button is selected for shipping");

		driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
		Log.info("Continue button is selected for shipping method");

		driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
		Log.info("Continue button is selected for payment method");

		driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
		Log.info("Continue button is selected for payment info");

		driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
		Log.info("Confirm button is clicked");

		String g = driver.findElement(By.xpath("//ul[@class='details']/li")).getText();
		Log.info(g);
	}
	
	public static void reOrder_CheckoutAction() {
		 driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
		 Log.info("Continue button is clicked after saving billing information");
    	             	
    	 driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
    	 Log.info("Continue button is clicked");
    	 
    	 Actions radio_btn= new Actions(driver);
    	 
    	 WebElement shipping_method= driver.findElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedRate']"));
    	 radio_btn.click(shipping_method).build().perform();
    	 Log.info("Shipping method radio button is clicked");            	 
    	 
    	 driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
    	 Log.info("Continue button clicked after selecting shipping method");
    	 
    	 driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
    	 Log.info("Continue buton is clicked after selecting payment method");
    	 
    	 driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
    	 Log.info("Contine button is clicked to save payment information");
    	 
    	 driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
    	 Log.info("Confirm button is clicked to confirm order");
    	 
    	String order_confirmation= driver.findElement(By.xpath("//ul[@class='details']/li[1]")).getText();
    	Log.info(order_confirmation);
	}
}
