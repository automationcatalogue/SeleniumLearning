package individualSeleniumScripts;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		System.out.println("Click action is performed on the Start button");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);
		
		WebElement element=wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver ob){
				WebElement element1=ob.findElement(By.xpath("//div[@id='finish']/h4"));
				if(element1.isDisplayed()){
					return element1;
				}else{
					return null;
				}
			}
		});
		
		System.out.println(element.getText());
		
				
	}

}
