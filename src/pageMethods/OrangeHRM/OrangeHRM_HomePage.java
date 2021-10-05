package pageMethods.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageMethods.BaseClass;
import utilities.Log;

public class OrangeHRM_HomePage {
	static WebDriver driver=BaseClass.getDriver();
	
	public static void clickAddEmployee() {
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Log.info("Selected PIM from the available options");
		
		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
		Log.info("Selected add employee option");
		
		driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
		Log.info("Add Employee modal exists ");
	}
	
	public static void clickUsers() {
		driver.findElement(By.xpath("(//span[text()='Admin'])[100]")).click();
		Log.info("Admin menu is clicked");
		
		driver.findElement(By.xpath("//span[text()='User Management']")).click();
		Log.info("User Management option is clicked");
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		Log.info("Useres option is clicked");
	}
	
}
