package pageMethods.airbnb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageMethods.BaseClass;
import utilities.Log;
import utilities.Utility;

public class AirbnbFilterPage {
	
	static int expected_maxPrice=35000;
	static int actual_maxprice=50000;
	static int expected_minprice=3000;
	static int actual_minprice=750;
	public static String dd_guests="//span[text()='Guests'])[1]";
	public static String btn_adults="(//button[@aria-label='increase value'])[1]";
	public static String btn_save="//button[text()='Save']";
	public static String btn_filters="//button[contains(@aria-label,'Filters')]/div/div";
	public static String chkbox_entirePlace="//input[@name='Entire place']";
	public static String chkbox_hotelRoom="//input[@name='Hotel room']";
	public static String btn_switch ="(//button[@role='switch'])[1]";
	public static String btn_maxPricefilter="//button[@aria-label='Maximum Price']";
	public static String btn_minPricefilter="//button[@aria-label='Minimum Price']";
	public static String btn_bedroom="(//button[@aria-label='increase value'])[2]";
	public static String btn_showListings="//button[@data-testid='more-filters-modal-submit-button']";
	public static String elementprice="//div[@itemprop='itemList']//following::div[@class='_1i1hiso']/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/span[1]";
	
	
	public static void allActionsInFilterWindow() throws Exception{
		BaseClass.getDriver().findElement(By.xpath(dd_guests)).click();
		Log.info("Guests dropdown is clicked");
		
		WebElement element_adults=BaseClass.getDriver().findElement(By.xpath(btn_adults));
		Actions action_click=new Actions(BaseClass.getDriver());
		action_click.click(element_adults).click(element_adults).build().perform();
		Log.info("Number of adults selected from filter : 2");
		
		BaseClass.getDriver().findElement(By.xpath(btn_save)).click();
		Log.info("Save button is clicked");
		
		BaseClass.getDriver().findElement(By.xpath(btn_filters)).click();
		Log.info("Filters button is clicked");
		
		Utility.waitForPageLoad(BaseClass.getDriver());
		Log.info("Employee details page is displayed");
		
		WebElement checkbox=BaseClass.getDriver().findElement(By.xpath(chkbox_entirePlace));
		if (!checkbox.isSelected()) {
			checkbox.click();
			Log.info("Entire place checkbox is selected");
		}else {
			Log.error("Entire place checkbox is already selected");
		}
		
		WebElement checkbox1=BaseClass.getDriver().findElement(By.xpath(chkbox_hotelRoom));
		if (!checkbox1.isSelected()) {
			checkbox1.click();
			Log.info("Hotel room checkbox is selected");
		}else {
			Log.error("checkbox is already selected");
		}
		
		WebElement verified_switch=BaseClass.getDriver().findElement(By.xpath(btn_switch));

		if (verified_switch.isSelected()) {
			verified_switch.click();
			Log.info("Airbnb switch is disabled");
		}else {
			Log.error("Airbnb switch is already disabled");
		}
		
		WebElement Maxprice_btn=BaseClass.getDriver().findElement(By.xpath(btn_maxPricefilter));
		
		Actions movepointerleft=new Actions(BaseClass.getDriver());
		
		while(actual_maxprice>=expected_maxPrice) {
			
			movepointerleft.clickAndHold(Maxprice_btn).moveByOffset(-50, 0).release().build().perform();
			String actualString_maxprice=Maxprice_btn.getAttribute("aria-valuenow");
			actual_maxprice=Integer.parseInt(actualString_maxprice);
			if(actual_maxprice<=expected_maxPrice) {
				Log.info("Final Actual max price is :"+actual_maxprice);
				break;
			}
		}
		
		
		WebElement Minprice_btn=BaseClass.getDriver().findElement(By.xpath(btn_minPricefilter));
		
		Actions movepointerright= new Actions(BaseClass.getDriver());
		
		
		while(actual_minprice<=expected_minprice) {
			movepointerright.clickAndHold(Minprice_btn).moveByOffset(50,0).release().build().perform();
			String actualString_minprice=Minprice_btn.getAttribute("aria-valuenow");
			actual_minprice=Integer.parseInt(actualString_minprice);
			if (actual_minprice>=expected_minprice) {
				Log.info("Final actual min price is " + actual_minprice);
				break;
			}
		}
		
		WebElement bedroom_btn=BaseClass.getDriver().findElement(By.xpath(btn_bedroom));
		Actions increase_btn=new Actions(BaseClass.getDriver());
		increase_btn.click(bedroom_btn).build().perform();
		Log.info("Number of bedrooms set to one");
		
		BaseClass.getDriver().findElement(By.xpath(btn_showListings)).click();
		Log.info("Show listings button is clicked");
	}
	
	public static void verifyFilterData() throws Exception{
		List<WebElement> element_price=BaseClass.getDriver().findElements(By.xpath(elementprice));
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
