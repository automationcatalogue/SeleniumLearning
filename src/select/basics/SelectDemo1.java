package select.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDemo1 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		System.out.println("Website is loaded with multi select list-box");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		System.out.println("switched into the iframe");
		WebElement element_listbox=driver.findElement(By.id("cars"));
		
		Select sListbox=new Select(element_listbox);
		
		if(sListbox.isMultiple()){
			
			System.out.println("List-box is multi selected");
			
			sListbox.selectByIndex(0);
			System.out.println("First value of list box is selected");
			
			Thread.sleep(3000);
			sListbox.selectByValue("opel");
			System.out.println("Opel is selected from the list box");
			
			Thread.sleep(3000);
			sListbox.selectByVisibleText("Audi");
			System.out.println("Audi is selected from the list box");
			
			WebElement element_listbox_value=sListbox.getFirstSelectedOption();
			String svalue=element_listbox_value.getText();
			System.out.println("First selected value from a list-box is :"+svalue);
			
//			driver.findElement(By.xpath("//input[@type='submit']")).click();
//			System.out.println("Submit button is clicked");
//			
//			driver.navigate().back();
			
//			sListbox.deselectByIndex(2);
//			System.out.println("Deselected the opel value from a list-box");
//			Thread.sleep(3000);
//			sListbox.deselectByValue("volvo");
//			System.out.println("Deselected the Volvo value from a list-box");
//			Thread.sleep(3000);
//			sListbox.deselectByVisibleText("Audi");
//			System.out.println("Deselected the Audi value from a list-box");
			
//			sListbox.deselectAll();
//			System.out.println("All selected values from a drop-down are deselected");
			
			System.out.println("Below are the List of selected options");
			List<WebElement> elements_values=sListbox.getAllSelectedOptions();
			for(WebElement element:elements_values){
				String s=element.getText();
				System.out.println(s);
			}
			
		}else{
			System.out.println("List-box is not multi selected");
		}
	}
}
