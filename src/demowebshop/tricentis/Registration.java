package demowebshop.tricentis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {

	static WebDriver driver;
	
	public static void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://testsautomation-trials71.orangehrmlive.com");
		driver.manage().window().maximize();
		
	}
	
	public static void register(){
		//driver.findElement().click();
	}
	
}
