package webdriverwaitScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitDemo1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testsautomation-trials71.orangehrmlive.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("Admin is entered as a Username");
		driver.findElement(By.name("txtPassword")).sendKeys("Admin@123");
		System.out.println("Admin@123 is the password is entered in a text-box");
			
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		System.out.println("Click action is performed on Login button");
		
		//WebElement element_empname=driver.findElement(By.xpath("//span[@class='postEmpName']"));
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='postEmpName']")));
		System.out.println("Home page is completely loaded");
		
		String parentID=driver.getWindowHandle();
		driver.findElement(By.xpath("//span[@class='postEmpName']")).click();
		System.out.println("Click action is performed on the Employee Name");
		
		Set<String> windowSessions=driver.getWindowHandles();
		for(String currentwindow:windowSessions){
			driver.switchTo().window(currentwindow);
		}
		System.out.println("Switched to the latest window");
		
		driver.findElement(By.xpath("//textarea[@id='createPost_content']")).sendKeys("Testing");
		System.out.println("Testing is entered in the Post Content text-box");
		
		WebElement element_postsubmit=driver.findElement(By.xpath("//button[@id='postSubmitBtn']"));
		element_postsubmit.click();
		System.out.println("Click action is performed on the Post button");
		
		//driver.close();
		//driver.switchTo().window(parentID);
		//System.out.println("Switched back to the parent window");
		
		wait.until(ExpectedConditions.invisibilityOf(element_postsubmit));
		System.out.println("Post button is now Invisible...!!!");
		
		
	}
}
