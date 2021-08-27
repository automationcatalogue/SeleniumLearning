package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo2 {
	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		System.out.println("Maximized the chrome browser");
		
		driver.get("https://jqueryui.com/droppable/");
		System.out.println("Website is loaded");
		
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);
		System.out.println("Switched into the frame");
		
		Actions action = new Actions(driver);
		WebElement element_source=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement element_destination = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		//action.dragAndDrop(element_source, element_destination);
		action.dragAndDropBy(element_source, 50, 70);
		action.build().perform();
		System.out.println("Drag and Drop operation is completed");
		
	}
}
