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
	
	public static void login(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		Log.info(username+" is entered as UserName in a text-box");
		
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		Log.info(password+" is entered as Password in a text-box");
		
		driver.findElement(By.id("btnLogin")).click();
		Log.info("Login button is clicked");
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[text()='Dashboard']")).isDisplayed());
		Log.info("Home page is displayed");
	}
	
	public static void logout() throws Exception{
		WebElement dropdown_logout = driver.findElement(By.xpath("//i[text()='keyboard_arrow_down']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",dropdown_logout);
		Log.info("Logout dropdown is clicked");
		
		WebElement element_logoutBtn=driver.findElement(By.xpath("//ul[@id='user_menu']//li[3]/a"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_logoutBtn);
		Log.info("Successfully logged out of the browser");
		
		Thread.sleep(2000);
	}
}
