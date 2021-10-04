package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import utilities.Log;

public class DemoWebShop_BrowsePage {
	static WebDriver driver;
	
	public static void addItemIntoCart() {
		WebElement dropdown_menu = driver.findElement(By.id("products-orderby"));
		Select scategory = new Select(dropdown_menu);

		scategory.selectByIndex(0);
		Log.info("first option selected from the dropdown");

		scategory.selectByValue("http://demowebshop.tricentis.com/books?orderby=6");
		Log.info("Category Z to A slected from the dropdown");

		driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
		Log.info("Added item to the cart");
		
		//cart
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		Log.info("Selected shopping cart");
	}
}
