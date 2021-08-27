package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickHeader {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//a[contains(text(),'Apparel & Shoes')])[1]")).click();
		System.out.println("Click action is performed on Apparel & Shoes header");
		
		int size=driver.findElements(By.xpath("//ul[@class='top-menu']/li/a")).size();
		System.out.println("Number of Headers are present :"+size);
	}
}
