package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageMethods.BaseClass;
import utilities.Log;

public class DemoWebShop_ShoppingBag {
	public static final String dd_countryID="//select[@name='CountryId']";
	public static final String dd_state="//select[@name='StateProvinceId']";
	public static final String txtbox_zipcode="//input[@name='ZipPostalCode']";
	public static final String btn_submit="//button[@type='submit']";
	public static final String chkbox_termsOfService ="//input[@id='termsofservice']";
	public static final String btn_checkout="//button[@id='checkout']";
	
	public static void allShoppingBagActions() {
		WebElement element_country = BaseClass.getDriver().findElement(By.xpath(dd_countryID));
		Select s1category = new Select(element_country);

		s1category.selectByVisibleText("India");
		Log.info("India is selected from the country drop down");

		WebElement element_state = BaseClass.getDriver().findElement(By.xpath(dd_state));
		Select s2category = new Select(element_state);

		s2category.selectByValue("0");
		Log.info("Other (Non US) selected from the state dropdown");

		BaseClass.getDriver().findElement(By.xpath(txtbox_zipcode)).clear();

		BaseClass.getDriver().findElement(By.xpath(txtbox_zipcode)).sendKeys("500020");
		Log.info("Entered pincode as 500020");

		WebElement element_chekbox = BaseClass.getDriver().findElement(By.id("termsofservice"));
		if (!element_chekbox.isSelected()) {
			element_chekbox.click();
			Log.info("Termsofservice Check-box is selected");
		} else {
			Log.warn("Termsofservice Check-box is already selected");
		}

		BaseClass.getDriver().findElement(By.xpath(btn_submit)).click();
		Log.info("Checkout button is clicked");
	}
	
	public static void reOrder_ShoppingBagAction() {
		 BaseClass.getDriver().findElement(By.xpath(chkbox_termsOfService)).click();
    	 Log.info("Terms of service check-box is clicked");
    	 
    	 BaseClass.getDriver().findElement(By.xpath(btn_checkout)).click();
    	 Log.info("Checkout button is clicked");
	}
}
