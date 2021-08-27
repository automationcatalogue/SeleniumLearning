package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testsautomation-trials71.orangehrmlive.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Admin@123");
	}
}
