package pageMethods.airbnb;

import org.openqa.selenium.By;

import pageMethods.BaseClass;
import utilities.Log;
import utilities.Utility;

public class AirbnbHomePage {
	
	public static String txtbox_location="//input[contains(@placeholder,'Where are you going')]";
	public static String btn_flexible="//div[text()='I’m flexible']";
	public static String page_searchResults="//div[@id='search-results-container']";
	
	public static void openFilterWindow() throws Exception{
		BaseClass.getDriver().findElement(By.xpath("//button[text()='OK']")).click();
		Log.info("Accept cookies button is clicked");
		
		//location
		BaseClass.getDriver().findElement(By.xpath(txtbox_location)).click();
		Log.info("Location is clicked ");
		
		Utility.waitForPageLoad(BaseClass.getDriver());
		
		BaseClass.getDriver().findElement(By.xpath(btn_flexible)).click();
		Log.info("I’m flexible button is clicked");
		
		BaseClass.getDriver().findElement(By.xpath(page_searchResults)).isDisplayed();
		Log.info("Search results are displayed");
	}
}
