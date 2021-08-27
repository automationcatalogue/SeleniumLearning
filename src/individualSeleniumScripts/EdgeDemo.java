package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Automation Catalogue\\Drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://testsautomation-trials71.orangehrmlive.com");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("Admin is the username is entered in a text-box");
		
		driver.findElement(By.name("txtPassword")).sendKeys("Admin@123");
		System.out.println("Admin@123 is the password is entered in a text-box");
		
		WebElement element_login=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_login);
		System.out.println("Click action is performed on Login button");
	}
}
