package individualSeleniumScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("login_page")));
		WebElement element_farme =driver.findElement(By.name("login_page"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element_farme));
		System.out.println("Switched into the frame...!!!");
		
		//driver.switchTo().frame(0);
		//System.out.println("Switched into the frame");
		
		driver.findElement(By.xpath("(//img[@alt='continue'])[1]")).click();
		System.out.println("Continue button is clicked without entering the username");
		
		
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert is appreared...!!!");
		
		Alert al=driver.switchTo().alert();
		al.accept();
		System.out.println("Alert is clicked");
	}
}
