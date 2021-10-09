package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import pageMethods.BaseClass;
import utilities.Log;

public class DemoWebShop_CustomerInfoPage {
	
	public static final String link_orders="//ul[@class='list']/li[3]/a";
	
	public static void clickOrders() {
		BaseClass.getDriver().findElement(By.xpath("//a[text()='aarosagarch@gmail.com']")).click();
		Log.info("Email name is clicked");
		
		//orders
		BaseClass.getDriver().findElement(By.xpath(link_orders)).click();
		Log.info("Orders selcted from the options");
	}
}
