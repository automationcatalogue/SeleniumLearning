package individualSeleniumScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriverDemo {
	
	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();//To open the chrome browser
		System.out.println("Chrome Browser is opened");
		driver.get("https://www.amazon.in");//To open the url
		System.out.println("Amazon.in website is loaded");
		driver.manage().window().maximize();//To maximize the browser window
		System.out.println("Browser is maximized");
		Thread.sleep(5000);//wait for 5 seconds
		
		driver.get("https://www.facebook.com");
		System.out.println("Facebook website is loaded");
		Thread.sleep(5000);//wait for 5 seconds
		
		driver.close();
		System.out.println("Chrome Browser is closed");
		
	}
}
