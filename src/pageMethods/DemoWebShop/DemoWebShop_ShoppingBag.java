package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class DemoWebShop_ShoppingBag {
	static WebDriver driver;
	
	public static void allShoppingBagActions() {
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
	}
	
	public static void reOrder_ShoppingBagAction() {
		 driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
    	 Reporter.log("Terms of service check-box is clicked", true);
    	 
    	 driver.findElement(By.xpath("//button[@id='checkout']")).click();
    	 Reporter.log("Checkout button is clicked", true);
	}
}
