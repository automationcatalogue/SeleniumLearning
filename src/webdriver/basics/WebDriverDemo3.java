package webdriver.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo3 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://automationcata-trials71.orangehrmlive.com");
		System.out.println("Orange HRM application website is loaded");
		String s=driver.getTitle();
		System.out.println("Title is :"+s);
		
		Window ob1=driver.manage().window();
		
		ob1.maximize();
		System.out.println("Browser window is maximized");

		Thread.sleep(5000);
		//ob1.fullscreen();
		
		Navigation n=driver.navigate();
		n.to("https://www.facebook.com");
		System.out.println("Facebook website is loaded");
		
		Thread.sleep(4000);
		n.back();
		
		Thread.sleep(3000);
		driver.navigate().forward();
		
		
		
		
		
	}
}
