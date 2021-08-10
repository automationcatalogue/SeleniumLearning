package webdriver.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo1 {
	
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		System.out.println("Amazon website is loaded");
		
		String s=driver.getTitle();
		System.out.println("Title of the Amazon website is :"+s);
		
		Thread.sleep(5000);
		
		driver.navigate().to("https://facebook.com");
		System.out.println("Facebook website is loaded");
		
		String s2=driver.getTitle();
		System.out.println("Title of the Facebook website is :"+s2);
		
		//driver.close();
		driver.quit();
		System.out.println("Chrome Driver is loaded");
		
	}
}
