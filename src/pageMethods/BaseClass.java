package pageMethods;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	//private static WebDriver driver;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	//This Parameterized constructor will assign the Testcase driver to the BaseClass driver
	public BaseClass(WebDriver driver) {
		this.driver.set(driver);
	}
	
	//This method is used to return the webDriver of a testcase
	public static WebDriver getDriver() {
		return driver.get();
	}
}
