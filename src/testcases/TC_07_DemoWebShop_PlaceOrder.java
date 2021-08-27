package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_07_DemoWebShop_PlaceOrder {
	public static void main(String[] args) throws Exception {
		Register.openBrowser();
		Login.login();

		Register.driver.findElement(By.xpath("(//ul[@class='top-menu']/li/a)[1]")).click();
		System.out.println("Selected Books from top menu");

		WebElement dropdown_menu = Register.driver.findElement(By.id("products-orderby"));
		Select scategory = new Select(dropdown_menu);

		scategory.selectByIndex(0);
		System.out.println("first opton selctted from the dropdown");
		Thread.sleep(3000);

		scategory.selectByValue("http://demowebshop.tricentis.com/books?orderby=6");
		System.out.println("Category ZtoA slected from the dropdown");
		Thread.sleep(3000);

		Register.driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
		System.out.println("Added item to the cart");

		Register.driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		System.out.println("Selected shoppng cart");
		Thread.sleep(3000);

		WebElement element_country = Register.driver.findElement(By.xpath("//select[@name='CountryId']"));
		Select s1category = new Select(element_country);

		s1category.selectByVisibleText("India");
		System.out.println("India selected from the country drop down");
		Thread.sleep(3000);

		WebElement element_state = Register.driver.findElement(By.xpath("//select[@name='StateProvinceId']"));
		Select s2category = new Select(element_state);

		s2category.selectByValue("0");
		System.out.println("Other (Non US) selected from the state dropdown");
		Thread.sleep(3000);

		Register.driver.findElement(By.xpath("//input[@name='ZipPostalCode']")).clear();

		Register.driver.findElement(By.xpath("//input[@name='ZipPostalCode']")).sendKeys("500060");
		System.out.println("Entered pincode as 500060");

		WebElement element_chekbox = Register.driver.findElement(By.id("termsofservice"));

		if (!element_chekbox.isSelected()) {
			element_chekbox.click();
			System.out.println("Check box is selected");
		} else {
			System.out.println("Check box is already selected");
		}

		Register.driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Checkout button is clicked");

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
		System.out.println("Continue button selected for billing");
		Thread.sleep(3000);

		Register.driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
		System.out.println("Continue button selected for shipping");
		Thread.sleep(3000);

		Register.driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
		System.out.println("Continue button selected for shipping method");
		Thread.sleep(2000);

		Register.driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
		System.out.println("Continue button selected for payment method");
		Thread.sleep(4000);

		Register.driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
		System.out.println("Continue button selected for payment info");
		Thread.sleep(2000);

		Register.driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
		System.out.println("Confirm button selected");

		String g = Register.driver.findElement(By.xpath("//ul[@class='details']/li")).getText();
		System.out.println(g);

	}

}