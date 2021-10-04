package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import utilities.Log;

public class DemoWebShop_CustomerInfoPage {
	static WebDriver driver;
	
	public static void clickOrders() {
		driver.findElement(By.xpath("//a[text()='aarosagarch@gmail.com']")).click();
		Log.info("Email name is clicked");
		
		//orders
		driver.findElement(By.xpath("//ul[@class='list']/li[3]/a")).click();
		Log.info("Orders selcted from the options");
	}
}
