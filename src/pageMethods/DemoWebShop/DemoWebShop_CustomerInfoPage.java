package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class DemoWebShop_CustomerInfoPage {
	static WebDriver driver;
	
	public static void clickOrders() {
		driver.findElement(By.xpath("//a[text()='aarosagarch@gmail.com']")).click();
		Reporter.log("Email name is clicked", true);
		
		//orders
		driver.findElement(By.xpath("//ul[@class='list']/li[3]/a")).click();
		Reporter.log("Orders selcted from the options", true);
	}
}
