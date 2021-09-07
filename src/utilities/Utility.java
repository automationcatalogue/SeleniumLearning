package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

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
	
	public static WebElement staleElement(WebDriver driver, String xpath) throws Exception{
		WebElement element=null;;
		for(int i=1;i<=2;i++) {
			try {
				element=driver.findElement(By.xpath(xpath));
				break;			
			}catch(StaleElementReferenceException se) {
				Thread.sleep(1000);
				Reporter.log("StaleElementReferenceException occured, retrying for same element...!!!", true);
			}catch(Exception e) {
				Reporter.log("Exception occurred while finding the element...!!!", true);
				e.getStackTrace();
			}
			
		}
		return element;
	}
 
}
