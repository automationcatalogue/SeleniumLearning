package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo4 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationcata-trials71.orangehrmlive.com");
		System.out.println("Orange HRM website is loaded");
		
		driver.manage().window().maximize();
		System.out.println("Browser window is maximized");
		
		WebElement element=driver.findElement(By.id("txtUsername"));
		element.sendKeys("Admin");
		System.out.println("Admin is entered as a Username");
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		System.out.println("admin123 is entered as a password");
		
		driver.findElement(By.xpath("//input[@name='Submit' and @id='btnLogin']")).click();
		System.out.println("Login button is clicked");
	}
}
