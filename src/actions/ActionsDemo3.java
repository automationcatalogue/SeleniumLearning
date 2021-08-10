package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo3 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		System.out.println("Maximized the chrome browser");
		
		driver.get("http://uitestpractice.com/students/actions");
		System.out.println("Website is loaded");
		
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		WebElement element_one=driver.findElement(By.xpath("//li[@name='one']"));
		WebElement element_six=driver.findElement(By.xpath("//li[@name='six']"));
		WebElement element_eleven=driver.findElement(By.xpath("//li[@name='eleven']"));
		WebElement element_eight=driver.findElement(By.xpath("//li[@name='eight']"));
		
		action.keyDown(element_one, Keys.CONTROL);
		action.click(element_six).click(element_eleven);
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		
		System.out.println("Key Up and Key Down actions performed...!!!");
		
		
		Thread.sleep(2000);
		action.click(element_eight).build().perform();
		
		
	}
}
