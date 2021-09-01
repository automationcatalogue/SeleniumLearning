package tesngScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGDemo1 {
	@Test
	public void login_OrangeHRM() {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://testseleniumcod-trials72.orangehrmlive.com");
		System.out.println("Website is loaded");
		driver.manage().window().maximize();
		System.out.println("Window is maximized");
	}
}
