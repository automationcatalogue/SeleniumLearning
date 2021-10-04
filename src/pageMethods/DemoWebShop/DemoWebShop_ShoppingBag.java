package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import utilities.Log;

public class DemoWebShop_ShoppingBag {
	static WebDriver driver;
	
	public static void allShoppingBagActions() {
		WebElement element_country = driver.findElement(By.xpath("//select[@name='CountryId']"));
		Select s1category = new Select(element_country);

		s1category.selectByVisibleText("India");
		Log.info("India is selected from the country drop down");

		WebElement element_state = driver.findElement(By.xpath("//select[@name='StateProvinceId']"));
		Select s2category = new Select(element_state);

		s2category.selectByValue("0");
		Log.info("Other (Non US) selected from the state dropdown");

		driver.findElement(By.xpath("//input[@name='ZipPostalCode']")).clear();

		driver.findElement(By.xpath("//input[@name='ZipPostalCode']")).sendKeys("500020");
		Log.info("Entered pincode as 500020");

		WebElement element_chekbox = driver.findElement(By.id("termsofservice"));
		if (!element_chekbox.isSelected()) {
			element_chekbox.click();
			Log.info("Termsofservice Check-box is selected");
		} else {
			Log.warn("Termsofservice Check-box is already selected");
		}

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Log.info("Checkout button is clicked");
	}
	
	public static void reOrder_ShoppingBagAction() {
		 driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
    	 Log.info("Terms of service check-box is clicked");
    	 
    	 driver.findElement(By.xpath("//button[@id='checkout']")).click();
    	 Log.info("Checkout button is clicked");
	}
}
