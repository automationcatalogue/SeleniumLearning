package pageMethods.airbnb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageMethods.BaseClass;
import utilities.Log;
import utilities.Utility;

public class AirbnbHomePage {
	static WebDriver driver=BaseClass.getDriver();
	
	public static void openFilterWindow() throws Exception{
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Log.info("Accept cookies button is clicked");
		
		//location
		driver.findElement(By.xpath("//input[contains(@placeholder,'Where are you going')]")).click();
		Log.info("Location is clicked ");
		
		Utility.waitForPageLoad(driver);
		
		driver.findElement(By.xpath("//div[text()='I’m flexible']")).click();
		Log.info("I’m flexible button is clicked");
		
		driver.findElement(By.xpath("//div[@id='search-results-container']")).isDisplayed();
		Log.info("Search results are displayed");
	}
}
