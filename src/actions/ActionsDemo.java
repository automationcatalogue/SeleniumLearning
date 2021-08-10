package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		
		WebElement element_category=driver.findElement(By.xpath("//a[text()='Log in']"));
		
		Actions action = new Actions(driver);
		action.click(element_category).perform();
		System.out.println("Login link is clicked");
		
		
		Thread.sleep(3000);
		action.sendKeys("aarosagarch@gmail.com").build().perform();
		
		WebElement element_password=driver.findElement(By.xpath("//input[@id='Password']"));
		//action.sendKeys(element_password,"Admin@123").build().perform();
		action.click(element_password).sendKeys("Admin@123").build().perform();
		
		/*
		WebElement element_computers = driver.findElement(By.xpath("(//a[contains(text(),'Computers')])[1]"));
		action.moveToElement(element_computers).click(element_computers).build().perform();*/
		
	}
}
