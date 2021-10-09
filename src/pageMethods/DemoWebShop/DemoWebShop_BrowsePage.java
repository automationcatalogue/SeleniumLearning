package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageMethods.BaseClass;
import utilities.Log;

public class DemoWebShop_BrowsePage {
	
	public static final String link_shoppingCart="//span[text()='Shopping cart']";
	public static final String btn_AddItemtoCart ="(//input[@value='Add to cart'])[1]";
	
	
	public static void addItemIntoCart() {
		WebElement dropdown_menu = BaseClass.getDriver().findElement(By.id("products-orderby"));
		Select scategory = new Select(dropdown_menu);

		scategory.selectByIndex(0);
		Log.info("first option selected from the dropdown");

		scategory.selectByValue("http://demowebshop.tricentis.com/books?orderby=6");
		Log.info("Category Z to A slected from the dropdown");

		BaseClass.getDriver().findElement(By.xpath(btn_AddItemtoCart)).click();
		Log.info("Added item to the cart");
		
		//cart
		BaseClass.getDriver().findElement(By.xpath(link_shoppingCart)).click();
		Log.info("Selected shopping cart");
	}
}
