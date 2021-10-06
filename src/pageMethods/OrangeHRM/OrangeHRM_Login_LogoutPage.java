package pageMethods.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import pageMethods.BaseClass;
import utilities.Log;

public class OrangeHRM_Login_LogoutPage {
	static WebDriver driver=BaseClass.getDriver();
	public static final String txtbox_username="txtUsername";
	public static final String txtbox_password="txtPassword";
	public static final String btn_Login="btnLogin";
	public static final String page_home="//li[text()='Dashboard']";
	public static final String dd_logoutOption="//i[text()='keyboard_arrow_down']";
	public static final String btn_logout="//ul[@id='user_menu']//li[3]/a";
	
	public static void login(String username, String password) {
		driver.findElement(By.id(txtbox_username)).sendKeys(username);
		Log.info(username+" is entered as UserName in a text-box");
		
		driver.findElement(By.name(txtbox_password)).sendKeys(password);
		Log.info(password+" is entered as Password in a text-box");
		
		driver.findElement(By.id(btn_Login)).click();
		Log.info("Login button is clicked");
		
		Assert.assertTrue(driver.findElement(By.xpath(page_home)).isDisplayed());
		Log.info("Home page is displayed");
	}
	
	public static void logout() throws Exception{
		WebElement dropdown_logout = driver.findElement(By.xpath(dd_logoutOption));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",dropdown_logout);
		Log.info("Logout dropdown is clicked");
		
		WebElement element_logoutBtn=driver.findElement(By.xpath(btn_logout));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_logoutBtn);
		Log.info("Successfully logged out of the browser");
		
		Thread.sleep(2000);
	}
}
