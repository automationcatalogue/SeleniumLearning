package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo {
	
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testsautomation-trials71.orangehrmlive.com");
		driver.manage().window().maximize();
		
		
		WebElement element_username=driver.findElement(By.id("txtUsername"));
		
		
		element_username.sendKeys("Sagar");
		System.out.println("Sagar is the username is entered in a text-box");
		Thread.sleep(3000);
		
		element_username.clear();
		Thread.sleep(3000);
		element_username.sendKeys("Admin");
		System.out.println("Admin is the username is entered in a text-box");
		
		driver.findElement(By.name("txtPassword")).sendKeys("Admin@123");
		System.out.println("Admin@123 is the password is entered in a text-box");
		
//		By locator_loginbtn=By.xpath("//input[@id='btnLogin']");
//		WebElement element_loginbtn=driver.findElement(locator_loginbtn);
//		element_loginbtn.click();
		
		WebElement element_loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		
		if(element_loginBtn.isEnabled()){
			element_loginBtn.click();
			System.out.println("Click action is performed on Login Button");
		}else{
			System.out.println("Login Button is not enabled");
		}
		
		
		
		
		
		Thread.sleep(6000);
		
		boolean dashboard=driver.findElement(By.xpath("//li[@class='page-title' and text()='Dashboard']")).isDisplayed();
		if(dashboard){
			System.out.println("Login is successful");
		}else{
			System.out.println("Login is failed");
		}
		
	}

}
