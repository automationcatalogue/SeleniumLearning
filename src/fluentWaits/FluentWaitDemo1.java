package fluentWaits;



import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo1 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testsautomation-trials71.orangehrmlive.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("Admin is the username is entered in a text-box");
		
		driver.findElement(By.name("txtPassword")).sendKeys("Admin@123");
		System.out.println("Admin@123 is the password is entered in a text-box");
		
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		System.out.println("Click action is performed on Login button");
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		System.out.println("Click action is performed on the PIM link");
		
		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
		System.out.println("Click action is performed on Add Employee button");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
		wait.until(new Function<WebDriver, Boolean>(){
					public Boolean apply(WebDriver ob){
						
						WebElement element_fullname=ob.findElement(By.xpath("//label[text()='Employee Full Name']"));
						
						String element_fullname_text=element_fullname.getText();
						
						if(element_fullname_text.contains("Employee Full Name")){
							System.out.println("Add Employee window is completely loaded");
							return true;
						}else{
							System.out.println("Add Employee window is not completely loaded");
							return false;
						}
					}
					
				});
		
		driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys("India");
		
		
		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
						
		
	}

}
