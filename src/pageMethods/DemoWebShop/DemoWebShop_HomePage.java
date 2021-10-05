package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageMethods.BaseClass;
import utilities.Log;

public class DemoWebShop_HomePage {
	static WebDriver driver = BaseClass.getDriver();
	
	public static void selectBooksCategory() {
		
		driver.findElement(By.xpath("(//ul[@class='top-menu']/li/a)[1]")).click();
		Log.info("Selected Books from top menu");
	}
}
