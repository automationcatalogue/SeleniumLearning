package pageMethods;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver driver;
	
	//This Parameterized constructor will assign the Testcase driver to the BaseClass driver
	public BaseClass(WebDriver driver) {
		this.driver=driver;
	}
	
	//This method is used to return the webDriver of a testcase
	public static WebDriver getDriver() {
		return driver;
	}
}
