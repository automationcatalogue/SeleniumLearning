package pageMethods.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class OrangeHRM_Login_LogoutPage {
	static WebDriver driver;
	
	public static void login(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		Reporter.log(username+" is entered as UserName in a text-box", true);
		
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		Reporter.log(password+" is entered as Password in a text-box", true);
		
		driver.findElement(By.id("btnLogin")).click();
		Reporter.log("Login button is clicked",true);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[text()='Dashboard']")).isDisplayed());
		Reporter.log("Home page is displayed", true);
	}
	
	public static void logout() throws Exception{
		WebElement dropdown_logout = driver.findElement(By.xpath("//i[text()='keyboard_arrow_down']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",dropdown_logout);
		Reporter.log("Logout dropdown is clicked", true);
		
		WebElement element_logoutBtn=driver.findElement(By.xpath("//ul[@id='user_menu']//li[3]/a"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_logoutBtn);
		Reporter.log("Successfully logged out of the browser", true);
		
		Thread.sleep(2000);
	}
}
