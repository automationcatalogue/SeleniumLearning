package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageMethods.BaseClass;
import utilities.Log;

public class DemoWebShop_Login_LogoutPage {
	static WebDriver driver=BaseClass.getDriver();
	public static final String btn_logout="//a[text()='Log out']";
	
	public static void login(String email, String password) throws Exception{

		driver.findElement(By.className("ico-login")).click();
		Log.info("Login button is clicked");
		
		
		driver.findElement(By.id("Email")).sendKeys(email);
		Log.info("Email Id is entered");
		
		driver.findElement(By.id("Password")).sendKeys(password);
		Log.info("Password is entered");
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Log.info("Login button is clicked");
		
	}
	
	public static void logout() throws Exception{
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(btn_logout)).click();
		Log.info("Successfully logged out of the browser");
	}
}
