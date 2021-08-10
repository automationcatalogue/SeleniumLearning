package webdriver.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo2 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/electronics/b/?ie=UTF8&node=976419031&ref_=nav_cs_electronics_c5b70a82461a484189e700166599ce9f");
		System.out.println("Amazon Website with Electronics product is loaded");
		
		Thread.sleep(3000);
		
		driver.get("https://en.wikipedia.org/wiki/Dominica");
		System.out.println("Wikipedia website is loaded");
		
		String url=driver.getCurrentUrl();
		System.out.println("URL of the application is :"+url);
		
		String pageSource=driver.getPageSource();
		System.out.println(pageSource);
	}
}
