package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TC_07_DemoWebShop_PlaceOrder {
	
	@Test
	public void placeOrder_DemoWebshop() throws Exception {
		Register.openBrowser();
		Login.login();
		
		Register.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Register.driver.findElement(By.xpath("(//ul[@class='top-menu']/li/a)[1]")).click();
		Reporter.log("Selected Books from top menu",true);

		WebElement dropdown_menu = Register.driver.findElement(By.id("products-orderby"));
		Select scategory = new Select(dropdown_menu);

		scategory.selectByIndex(0);
		Reporter.log("first option selected from the dropdown", true);

		scategory.selectByValue("http://demowebshop.tricentis.com/books?orderby=6");
		Reporter.log("Category Z to A slected from the dropdown", true);

		Register.driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
		Reporter.log("Added item to the cart",true);

		Register.driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		Reporter.log("Selected shoppng cart",true);

		WebElement element_country = Register.driver.findElement(By.xpath("//select[@name='CountryId']"));
		Select s1category = new Select(element_country);

		s1category.selectByVisibleText("India");
		Reporter.log("India selected from the country drop down", true);

		WebElement element_state = Register.driver.findElement(By.xpath("//select[@name='StateProvinceId']"));
		Select s2category = new Select(element_state);

		s2category.selectByValue("0");
		Reporter.log("Other (Non US) selected from the state dropdown",true);

		Register.driver.findElement(By.xpath("//input[@name='ZipPostalCode']")).clear();

		Register.driver.findElement(By.xpath("//input[@name='ZipPostalCode']")).sendKeys("500060");
		Reporter.log("Entered pincode as 500060",true);

		WebElement element_chekbox = Register.driver.findElement(By.id("termsofservice"));

		if (!element_chekbox.isSelected()) {
			element_chekbox.click();
			Reporter.log("Check box is selected",true);
		} else {
			Reporter.log("Check box is already selected",true);
		}

		Register.driver.findElement(By.xpath("//button[@type='submit']")).click();
		Reporter.log("Checkout button is clicked",true);

// WebElement elemant_selectcountry=Register.driver.findElement(By.xpath("//select[@name='BillingNewAddress.CountryId']"));
// Select s3category=new Select(elemant_selectcountry);
//
// s3category.selectByVisibleText("India");
// System.out.println("India selected from the dropdown list");
//
// Register.driver.findElement(By.xpath("//input[@name='BillingNewAddress.City']")).sendKeys("Hydrabad");
// System.out.println("Entered city name");
//
// Register.driver.findElement(By.xpath("//input[@name='BillingNewAddress.Address1']")).sendKeys("5958");
// System.out.println("Entered Adress1 details");
//
// Register.driver.findElement(By.xpath("//input[@name='BillingNewAddress.ZipPostalCode']")).sendKeys("500060");
// System.out.println("Entered pincode number");
//
// Register.driver.findElement(By.xpath("//input[@name='BillingNewAddress.PhoneNumber']")).sendKeys("9121763760");
// System.out.println("Entered phone number");

		Register.driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
		Reporter.log("Continue button selected for billing", true);

		Register.driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
		Reporter.log("Continue button selected for shipping",true);

		Register.driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
		Reporter.log("Continue button selected for shipping method",true);

		Register.driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
		Reporter.log("Continue button selected for payment method",true);

		Register.driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
		Reporter.log("Continue button selected for payment info",true);

		Register.driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
		Reporter.log("Confirm button selected",true);

		String g = Register.driver.findElement(By.xpath("//ul[@class='details']/li")).getText();
		Reporter.log(g, true);

	}
	
	@AfterClass
	public void afterClass() {
		Register.driver.quit();
	}
		
}