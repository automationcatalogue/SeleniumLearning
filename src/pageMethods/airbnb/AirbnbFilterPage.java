package pageMethods.airbnb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageMethods.BaseClass;
import utilities.Log;
import utilities.Utility;

public class AirbnbFilterPage {
	
	static WebDriver driver=BaseClass.getDriver();
	static int expected_maxPrice=35000;
	static int actual_maxprice=50000;
	static int expected_minprice=3000;
	static int actual_minprice=750;
	
	public static void allActionsInFilterWindow() throws Exception{
		driver.findElement(By.xpath("(//span[text()='Guests'])[1]")).click();
		Log.info("Guests dropdown is clicked");
		
		WebElement element_adults=driver.findElement(By.xpath("(//button[@aria-label='increase value'])[1]"));
		Actions action_click=new Actions(driver);
		action_click.click(element_adults).click(element_adults).build().perform();
		Log.info("Number of adults selected from filter : 2");
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Log.info("Save button is clicked");
		
		driver.findElement(By.xpath("//button[contains(@aria-label,'Filters')]/div/div")).click();
		Log.info("Filters button is clicked");
		
		Utility.waitForPageLoad(driver);
		Log.info("Employee details page is displayed");
		
		WebElement checkbox=driver.findElement(By.xpath("//input[@name='Entire place']"));
		if (!checkbox.isSelected()) {
			checkbox.click();
			Log.info("Entire place checkbox is selected");
		}else {
			Log.error("Entire place checkbox is already selected");
		}
		
		WebElement checkbox1=driver.findElement(By.xpath("//input[@name='Hotel room']"));
		if (!checkbox1.isSelected()) {
			checkbox1.click();
			Log.info("Hotel room checkbox is selected");
		}else {
			Log.error("checkbox is already selected");
		}
		
		WebElement verified_switch=driver.findElement(By.xpath("(//button[@role='switch'])[1]"));

		if (verified_switch.isSelected()) {
			verified_switch.click();
			Log.info("Airbnb switch is disabled");
		}else {
			Log.error("Airbnb switch is already disabled");
		}
		
		WebElement Maxprice_btn=driver.findElement(By.xpath("//button[@aria-label='Maximum Price']"));
		//WebElement element_MaxPrice=driver.findElement(By.xpath("//input[@id='price_filter_max']"));
		
		Actions movepointerleft=new Actions(driver);
		
		while(actual_maxprice>=expected_maxPrice) {
			
			movepointerleft.clickAndHold(Maxprice_btn).moveByOffset(-50, 0).release().build().perform();
			String actualString_maxprice=Maxprice_btn.getAttribute("aria-valuenow");
			actual_maxprice=Integer.parseInt(actualString_maxprice);
			if(actual_maxprice<=expected_maxPrice) {
				Log.info("Final Actual max price is :"+actual_maxprice);
				break;
			}
		}
		
		
		WebElement Minprice_btn=driver.findElement(By.xpath("//button[@aria-label='Minimum Price']"));
		
		Actions movepointerright= new Actions(driver);
		
		
		while(actual_minprice<=expected_minprice) {
			movepointerright.clickAndHold(Minprice_btn).moveByOffset(50,0).release().build().perform();
			String actualString_minprice=Minprice_btn.getAttribute("aria-valuenow");
			actual_minprice=Integer.parseInt(actualString_minprice);
			if (actual_minprice>=expected_minprice) {
				Log.info("Final actual min price is " + actual_minprice);
				break;
			}
		}
		
		WebElement bedroom_btn=driver.findElement(By.xpath("(//button[@aria-label='increase value'])[2]"));
		Actions increase_btn=new Actions(driver);
		increase_btn.click(bedroom_btn).build().perform();
		Log.info("Number of bedrooms set to one");
		
		driver.findElement(By.xpath("//button[@data-testid='more-filters-modal-submit-button']")).click();
		Log.info("Show listings button is clicked");
	}
	
	public static void verifyFilterData() throws Exception{
		List<WebElement> element_price=driver.findElements(By.xpath("//div[@itemprop='itemList']//following::div[@class='_1i1hiso']/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/span[1]"));
		int size= element_price.size();
		//Log.info(size);
		
		for (WebElement element:element_price) {
			
			String price=element.getText();
			Log.info("Price of the elements is "+ price);
			price=price.replace(",","");
			Log.info("Price of the elements is "+ price);
			price=price.substring(1);
			Log.info("Price of the elements is "+ price);
			int pricevalue=Integer.parseInt(price);
			
			if (pricevalue>=actual_minprice && pricevalue<=actual_maxprice) {
				Log.info("Element price is within the range");
			}else {
				Log.error("Element price is not within the range");
				throw new Exception();
			}
		}
	}
}
