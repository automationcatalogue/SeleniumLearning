package desiredcaps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IEDemo {
	public static void main(String[] args) {
		WebDriverManager.iedriver().setup();
		
		
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("ignoreProtectedModeSettings", true);
		dc.setCapability("ignoreZoomSetting", true);
		
		
		InternetExplorerOptions ieOptions = new InternetExplorerOptions();
		ieOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);//This determines whether the driver should attempt to remove obsolete elements from the element cache on page navigation
		ieOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);//To make the mouse over events at the last location the mouse cursor has been moved to.
		ieOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);//To Make the IE browser having the focus on execution
		ieOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);//To Disable the Native Events of IE browser
		
		ieOptions.merge(dc);
		
		WebDriver driver = new InternetExplorerDriver(ieOptions);
		
		
		driver.get("https://testsautomation-trials71.orangehrmlive.com");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("Admin is the username is entered in a text-box");
		
		driver.findElement(By.name("txtPassword")).sendKeys("Admin@123");
		System.out.println("Admin@123 is the password is entered in a text-box");
		
		WebElement element_login=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_login);
		System.out.println("Click action is performed on Login button");
	}
}
