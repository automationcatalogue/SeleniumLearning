package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_intro_inner_html");
		driver.manage().window().maximize();
		
		//driver.switchTo().frame("iframeResult");
		WebElement element_frame=driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(element_frame);
		System.out.println("Switched into the frame");
		
		driver.findElement(By.xpath("//button[text()='Click Me!']")).click();
		System.out.println("Click action is performed on Click Me! button");
		
		driver.switchTo().defaultContent();
		System.out.println("Exited from the frame");
		
		driver.findElement(By.xpath("//a[text()='Get your own website']")).click();
		System.out.println("Get your ownwebsite button is clicked");
		
	}
}
