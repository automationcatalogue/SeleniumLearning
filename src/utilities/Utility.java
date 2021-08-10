package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	
	public static void selection_dropdown(WebDriver ob, String xpathvalue, String expectedData) {
		List<WebElement> GroupOfelements=ob.findElements(By.xpath(xpathvalue));

		for(WebElement eachElement:GroupOfelements) {
			String actualData=eachElement.getText();
			
			if (actualData.equalsIgnoreCase(expectedData)) {
				eachElement.click();
				System.out.println(actualData + " Is selected from the dropdown");
				break;
			}
		}
	}
 
}
