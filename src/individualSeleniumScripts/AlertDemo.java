package individualSeleniumScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		System.out.println("Website is launched");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		System.out.println("Switched into the frame");
		
		driver.findElement(By.xpath("//a[@onclick='return fLogon();']")).click();
		System.out.println("Continue button is clicked");
		
		Thread.sleep(2000);
		
		Alert alert=driver.switchTo().alert();
		System.out.println("Switched to the Alert...!!!");
		
		Thread.sleep(2000);
		alert.accept();
		System.out.println("Alert is accepted...!!!");
		
	}
}
