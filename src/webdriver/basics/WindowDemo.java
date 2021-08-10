package webdriver.basics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Constant;

public class WindowDemo {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		System.out.println("IRCTC website is launched");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		System.out.println("Click action is performed on OK button");
		
		String parentWindowSessionID=driver.getWindowHandle();
		System.out.println("Parent Window Session ID is :"+parentWindowSessionID);
		
		driver.findElement(By.xpath("(//a[@aria-label='PNR Status opens a new window'])[1]")).click();
		System.out.println("Click action is performed on PNR Status button");
		
		System.out.println("Another window is opened");
		Thread.sleep(2000);
		driver.switchTo().window(parentWindowSessionID);
		System.out.println("Switched back to the Parent Window");
		
		Set<String> sessionIds=driver.getWindowHandles();
		for(String session:sessionIds){
			driver.switchTo().window(session);
		}
		System.out.println("Switched into the latest window");
		String latestSessionID=driver.getWindowHandle();
		
		Thread.sleep(2000);
		driver.switchTo().window(parentWindowSessionID);
		System.out.println("Switched back to the Parent Window");
		
		driver.close();
		
		driver.switchTo().window(latestSessionID);
		
		driver.findElement(By.xpath("//input[@class='form-control_custom input_text_custom' and @id='inputPnrNo']")).sendKeys(Constant.PNRNumber);
		System.out.println("PNR Number is entered");
		
		driver.findElement(By.xpath("//input[@id='modal1']")).click();
		System.out.println("Click action is performed on Submit button");
		
		
		
	}
}
