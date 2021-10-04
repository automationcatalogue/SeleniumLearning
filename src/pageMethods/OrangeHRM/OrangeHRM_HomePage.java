package pageMethods.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class OrangeHRM_HomePage {
	static WebDriver driver;
	
	public static void clickAddEmployee() {
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Reporter.log("Selected PIM from the available options",true);
		
		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
		Reporter.log("Selected add employee option", true);
		
		driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
		Reporter.log("Add Employee modal exists ", true);
	}
	
	public static void clickUsers() {
		driver.findElement(By.xpath("(//span[text()='Admin'])[100]")).click();
		Reporter.log("Admin menu is clicked", true);
		
		driver.findElement(By.xpath("//span[text()='User Management']")).click();
		Reporter.log("User Management option is clicked", true);
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		Reporter.log("Useres option is clicked",true);
	}
	
}
