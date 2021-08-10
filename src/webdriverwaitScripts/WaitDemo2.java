package webdriverwaitScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDemo2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement element_electronics = driver.findElement(By.xpath("(//a[contains(text(),'Computers')])[1]"));
		action.moveToElement(element_electronics).build().perform();
		System.out.println("Mouse hover action is performed on the Computers menu");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[contains(text(),'Desktop')])[1]")));
		System.out.println("Desktop is available in the DOM...!!!");
		
		driver.findElement(By.xpath("(//a[contains(text(),'Desktop')])[1]")).click();
		System.out.println("Click action is performed on Desktop...!!!");
		
		wait.until(ExpectedConditions.titleContains("Demo Web Shop. testing"));
		System.out.println("Desktop page is loaded...!!!");
		
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='products-orderby']/option")));
		System.out.println("Complete Data is loaded in the drop-down...!!!");
		
		WebElement element_text=driver.findElement(By.xpath("//div[@class='page-body']//following-sibling::strong"));
		wait.until(ExpectedConditions.textToBePresentInElement(element_text, "Filter by price"));
	}
	
}
