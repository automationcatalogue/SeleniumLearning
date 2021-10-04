package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class DemoWebShop_CheckoutPage {
	static WebDriver driver;
	
	public static void allCheckoutActions() {
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
	}
	
	public static void reOrder_CheckoutAction() {
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
	}
}
