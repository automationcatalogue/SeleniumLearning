package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDemo {
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("India");
		driver.findElement(By.name("q")).submit();
	}
}
