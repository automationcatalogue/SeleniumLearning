package individualSeleniumScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDemo {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		System.out.println("Amazon website is loaded");
		
		driver.manage().window().maximize();
		
		WebElement element_category=driver.findElement(By.xpath("//select[@id='searchDropdownBox' and @name='url']"));
		Select sCategory= new Select(element_category);
		
		sCategory.selectByIndex(10);
		System.out.println("10th value is selected from a drop-down");
		
		Thread.sleep(3000);
		
		sCategory.selectByIndex(15);
		System.out.println("15th value is selected from a drop-down");
		
		Thread.sleep(3000);
		sCategory.selectByValue("search-alias=pantry");
		System.out.println("Amazon Pantry value is selected from a drop-down");
		
		Thread.sleep(3000);
		sCategory.selectByVisibleText("Industrial & Scientific");
		System.out.println("Industrial & Scientific is slected from a drop-down");
		
		boolean bCategory=sCategory.isMultiple();
		if(bCategory){
			System.out.println("Category drop-down can select the multiple values");
		}else{
			System.out.println("Category drop-down can't select the multiple values");
		}
		System.out.println("Below are the Available options");
		
		List<WebElement> elements_categories=sCategory.getOptions();
		for(WebElement element:elements_categories){
			System.out.println(element.getText());
		}
	}
}
