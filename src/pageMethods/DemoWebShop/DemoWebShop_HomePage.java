package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class DemoWebShop_HomePage {
	static WebDriver driver;
	
	public static void selectBooksCategory() {
		
		driver.findElement(By.xpath("(//ul[@class='top-menu']/li/a)[1]")).click();
		Reporter.log("Selected Books from top menu",true);
	}
}
