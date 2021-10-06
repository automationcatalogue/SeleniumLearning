package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageMethods.BaseClass;
import utilities.Log;

public class DemoWebShop_CustomerInfoPage {
	static WebDriver driver=BaseClass.getDriver();
	public static final String link_orders="//ul[@class='list']/li[3]/a";
	
	public static void clickOrders() {
		driver.findElement(By.xpath("//a[text()='aarosagarch@gmail.com']")).click();
		Log.info("Email name is clicked");
		
		//orders
		driver.findElement(By.xpath(link_orders)).click();
		Log.info("Orders selcted from the options");
	}
}
