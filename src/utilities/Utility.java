package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	
	public static void selection_dropdown(WebDriver driver, String xpathvalue, String expectedData) {
		List<WebElement> GroupOfelements=driver.findElements(By.xpath(xpathvalue));

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
	
	public static boolean retryClick(WebDriver driver, By by) throws Exception{		
		boolean result = false;
		
		for(int attempts = 0;attempts<2;attempts++) {
			try {
					driver.findElement(by).click();
		            result = true;
		            break;
			} catch(StaleElementReferenceException e) {
				Reporter.log("StaleElementReferenceException occured, retrying for same element...!!!", true);
			}
			
		}
		return result;		
	}
	
	public static WebDriver getDriver(String browser) {
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("InternetExplorer") || browser.equalsIgnoreCase("IE") || browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("Opera") ) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		return driver;
	}
 
}
