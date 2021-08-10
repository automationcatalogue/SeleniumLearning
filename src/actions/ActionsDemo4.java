package actions;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo4 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		System.out.println("Maximized the chrome browser");
		
		driver.get("http://uitestpractice.com/students/actions");
		System.out.println("Website is loaded");
		
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		WebElement element_source = driver.findElement(By.id("draggable"));
		WebElement element_destination = driver.findElement(By.xpath("//div[@id='div2']"));
		
		action.clickAndHold(element_source);
		action.release(element_destination);
		action.build().perform();
		System.out.println("Click and Hold & Release actions are performed...!!!");
		
		Thread.sleep(2000);
		action.contextClick(element_destination).build().perform();
		System.out.println("Right click action is performed");
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		System.out.println("DOWN button is clicked one time");
		
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		System.out.println("DOWN button is clicked second time");
		
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		System.out.println("DOWN button is clicked thrird time");
		

		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("DOWN button is clicked thrird time");
		
		
	}
}
