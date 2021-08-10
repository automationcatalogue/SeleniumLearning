package webdriver.basics;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshotDemo {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://testsautomation-trials71.orangehrmlive.com/");
		System.out.println("Orange HRM website is loaded");
		 
		
			driver.manage().window().maximize();
			System.out.println("Browser window is maximized");
			
			WebElement element=driver.findElement(By.id("txtUsername"));
			element.sendKeys("Admin");
			System.out.println("Admin is entered as a Username");
			captureScreenshot(driver, "Sagar");
			
			
			driver.findElement(By.name("txtPassword")).sendKeys("Admin@123");
			System.out.println("admin123 is entered as a password");
			captureScreenshot(driver, "Vijetha");
		
			
			driver.findElement(By.xpath("//input[@name='Submit' and @id='btnLogin']")).click();
			System.out.println("Login button is clicked");
			
			
			
			String s=driver.findElement(By.xpath("//li[text()='Dashboard']")).getText();
			System.out.println("Home Page is loaded...!!! "+s);
			captureScreenshot(driver, "Prashanth");
			
		
			
	}
	
	public static void captureScreenshot(WebDriver driver, String screenshotName) throws Exception{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Eclipse\\SeleniumLectures\\SeleniumLearning\\Screenshots\\"+screenshotName+".jpg");
		FileUtils.copyFile(source, destination);
	}
}
