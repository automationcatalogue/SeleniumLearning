package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDemo_DesiredCaps {
	public static void main(String[] args) {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		options.addArguments("--disable-popup-blocking");//To Disable the pop-up blocker
		options.addArguments("--ignore-certificate-errors");//To Ignore the certificate related errors
		
		
		WebDriverManager.chromedriver().setup();
		
		
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://testsautomation-trials71.orangehrmlive.com");
				
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("Admin is the username is entered in a text-box");
		
		driver.findElement(By.name("txtPassword")).sendKeys("Admin@123");
		System.out.println("Admin@123 is the password is entered in a text-box");
		
		WebElement element_login=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_login);
		System.out.println("Click action is performed on Login button");
	
	}
}
