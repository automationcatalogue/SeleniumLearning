package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo5 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		System.out.println("Maximized the chrome browser");
		
		driver.get("https://jqueryui.com/slider/#colorpicker");
		System.out.println("Website is loaded");
		
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);
		System.out.println("Switched into the frame");
		
		Actions action = new Actions(driver);
		WebElement element_slider1= driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
		action.clickAndHold(element_slider1).moveByOffset(-90,0).release().build().perform();
		System.out.println("Moved back by 50 pixels");
		
		
	}
}
