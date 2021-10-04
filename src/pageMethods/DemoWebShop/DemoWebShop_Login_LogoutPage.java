package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class DemoWebShop_Login_LogoutPage {
	static WebDriver driver;
	
	public static void login(String email, String password) throws Exception{
		
		driver.findElement(By.className("ico-login")).click();
		Reporter.log("Login button is clicked", true);
		
		
		driver.findElement(By.id("Email")).sendKeys(email);
		Reporter.log("Email Id is entered",true);
		
		driver.findElement(By.id("Password")).sendKeys(password);
		Reporter.log("Password is entered", true);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("Login button is clicked", true);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		Reporter.log("Successfully logged out of the browser", true);
	}
	
	public static void logout() throws Exception{
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		Reporter.log("Successfully logged out of the browser", true);
	}
}
