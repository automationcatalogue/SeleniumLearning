package pageMethods.airbnb;

import org.openqa.selenium.By;

import pageMethods.BaseClass;
import utilities.Log;
import utilities.Utility;

public class AirbnbHomePage {
	
	public static void openFilterWindow() throws Exception{
		BaseClass.getDriver().findElement(By.xpath("//button[text()='OK']")).click();
		Log.info("Accept cookies button is clicked");
		
		//location
		BaseClass.getDriver().findElement(By.xpath("//input[contains(@placeholder,'Where are you going')]")).click();
		Log.info("Location is clicked ");
		
		Utility.waitForPageLoad(BaseClass.getDriver());
		
		BaseClass.getDriver().findElement(By.xpath("//div[text()='I’m flexible']")).click();
		Log.info("I’m flexible button is clicked");
		
		BaseClass.getDriver().findElement(By.xpath("//div[@id='search-results-container']")).isDisplayed();
		Log.info("Search results are displayed");
	}
}
