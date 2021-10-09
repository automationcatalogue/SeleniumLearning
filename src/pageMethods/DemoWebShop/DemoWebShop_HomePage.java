package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import pageMethods.BaseClass;
import utilities.Log;

public class DemoWebShop_HomePage {
	
	public static final String link_books="(//ul[@class='top-menu']/li/a)[1]";
	
	public static void selectBooksCategory() {
		
		BaseClass.getDriver().findElement(By.xpath(link_books)).click();
		Log.info("Selected Books from top menu");
	}
}
