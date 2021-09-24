package utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	
	public static void selection_dropdown(WebDriver driver, String xpathvalue, String expectedData) {
		List<WebElement> GroupOfelements=driver.findElements(By.xpath(xpathvalue));

		for(WebElement eachElement:GroupOfelements) {
			String actualData=eachElement.getText();
			
			if (actualData.equalsIgnoreCase(expectedData)) {
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", eachElement);
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
					//driver.findElement(by).click();
					((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(by));
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
	
	public static void waitForPageLoad_sample(WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			       
		wait.until(new Function<WebDriver, Boolean>() {
		     public Boolean apply(WebDriver driver) {
		       return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equalsIgnoreCase("complete");
		     }
		});
	}
	
	public static void waitForPageLoad(WebDriver driver) throws Exception{
		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equalsIgnoreCase("complete");
			}
		};
		
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(condition);
	}
	
	
 
}
