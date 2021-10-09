package pageMethods.DemoWebShop;

import org.openqa.selenium.By;

import pageMethods.BaseClass;
import utilities.Log;

public class DemoWebShop_Login_LogoutPage{
	
	public static final String btn_logout="//a[text()='Log out']";
	
	public static void login(String email, String password) throws Exception{

		BaseClass.getDriver().findElement(By.className("ico-login")).click();
		Log.info("Login button is clicked");
		
		
		BaseClass.getDriver().findElement(By.id("Email")).sendKeys(email);
		Log.info("Email Id is entered");
		
		BaseClass.getDriver().findElement(By.id("Password")).sendKeys(password);
		Log.info("Password is entered");
		
		BaseClass.getDriver().findElement(By.xpath("//input[@value='Log in']")).click();
		Log.info("Login button is clicked");
		
	}
	
	public static void logout() throws Exception{
		Thread.sleep(3000);
		
		BaseClass.getDriver().findElement(By.xpath(btn_logout)).click();
		Log.info("Successfully logged out of the browser");
	}
}
