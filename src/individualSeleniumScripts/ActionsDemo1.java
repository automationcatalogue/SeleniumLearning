package individualSeleniumScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo1 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://uitestpractice.com/students/actions");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		
		WebElement element_singlebtn=driver.findElement(By.xpath("//button[text()='Click Me !']"));
		WebElement element_doublebtn=driver.findElement(By.xpath("//button[text()='Double Click Me !']"));
		
		action.moveToElement(element_singlebtn).click().build().perform();
		Thread.sleep(2000);
		
		Alert alert =driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		action.moveToElement(element_doublebtn).doubleClick().build().perform();
		Thread.sleep(3000);
		Alert alert1 =driver.switchTo().alert();
		alert1.accept();
	}
}
