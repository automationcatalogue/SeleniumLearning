package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageMethods.BaseClass;
import utilities.Log;

public class DemoWebShop_CheckoutPage {
	
	public static final String btn_billingdetails= "//input[@onclick='Billing.save()']";
	public static final String btn_shippingOption="//input[@onclick='Shipping.save()']";
	public static final String btn_shippingMethod="//input[@onclick='ShippingMethod.save()']";
	public static final String btn_paymentOption="//input[@onclick='PaymentMethod.save()']";
	public static final String btn_paymentInfo="//input[@onclick='PaymentInfo.save()']";
	public static final String btn_confirm="//input[@onclick='ConfirmOrder.save()']";
	public static final String rbtn_shippingmethod="//input[@value='Next Day Air___Shipping.FixedRate']";
	
	public static void allCheckoutActions() {
		WebDriver driver = BaseClass.getDriver();
		BaseClass.getDriver().findElement(By.xpath(btn_billingdetails)).click();
		Log.info("Continue button is selected for billing");

		BaseClass.getDriver().findElement(By.xpath(btn_shippingOption)).click();
		Log.info("Continue button is selected for shipping");

		BaseClass.getDriver().findElement(By.xpath(btn_shippingMethod)).click();
		Log.info("Continue button is selected for shipping method");

		BaseClass.getDriver().findElement(By.xpath(btn_paymentOption)).click();
		Log.info("Continue button is selected for payment method");

		BaseClass.getDriver().findElement(By.xpath(btn_paymentInfo)).click();
		Log.info("Continue button is selected for payment info");

		BaseClass.getDriver().findElement(By.xpath(btn_confirm)).click();
		Log.info("Confirm button is clicked");

		String g = BaseClass.getDriver().findElement(By.xpath("//ul[@class='details']/li")).getText();
		Log.info(g);
	}
	
	public static void reOrder_CheckoutAction() {
		 BaseClass.getDriver().findElement(By.xpath(btn_billingdetails)).click();
		 Log.info("Continue button is clicked after saving billing information");
    	             	
    	 BaseClass.getDriver().findElement(By.xpath(btn_shippingOption)).click();
    	 Log.info("Continue button is clicked");
    	 
    	 Actions radio_btn= new Actions(BaseClass.getDriver());
    	 
    	 WebElement shipping_method= BaseClass.getDriver().findElement(By.xpath(rbtn_shippingmethod));
    	 radio_btn.click(shipping_method).build().perform();
    	 Log.info("Shipping method radio button is clicked");            	 
    	 
    	 BaseClass.getDriver().findElement(By.xpath(btn_shippingMethod)).click();
    	 Log.info("Continue button clicked after selecting shipping method");
    	 
    	 BaseClass.getDriver().findElement(By.xpath(btn_paymentOption)).click();
    	 Log.info("Continue buton is clicked after selecting payment method");
    	 
    	 BaseClass.getDriver().findElement(By.xpath(btn_paymentInfo)).click();
    	 Log.info("Contine button is clicked to save payment information");
    	 
    	 BaseClass.getDriver().findElement(By.xpath(btn_confirm)).click();
    	 Log.info("Confirm button is clicked to confirm order");
    	 
    	String order_confirmation= BaseClass.getDriver().findElement(By.xpath("//ul[@class='details']/li[1]")).getText();
    	Log.info(order_confirmation);
	}
}
