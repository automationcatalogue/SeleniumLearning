package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDemo3 {
	
			
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
		/*Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Account & Lists']"))).build().perform();
		System.out.println("Click action is performed on Accounts & Lists link...");
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Sign in'])[1]")));*/
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='nav-xshop']/a")));
		
		
		
	}
}
