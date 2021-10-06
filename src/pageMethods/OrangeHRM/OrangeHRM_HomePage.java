package pageMethods.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageMethods.BaseClass;
import utilities.Log;

public class OrangeHRM_HomePage {
	static WebDriver driver=BaseClass.getDriver();
	public static final String link_PIM="//span[text()='PIM']";
	public static final String link_addEmployee="//span[text()='Add Employee']";
	public static final String page_addemployee="//div[@class='modal-content']";
	public static final String menu_admin="(//span[text()='Admin'])[100]";
	public static final String link_userManagement="//span[text()='User Management']";
	public static final String link_users="//span[text()='Users']";
	
	public static void clickAddEmployee() {
		driver.findElement(By.xpath(link_PIM)).click();
		Log.info("Selected PIM from the available options");
		
		driver.findElement(By.xpath(link_addEmployee)).click();
		Log.info("Selected add employee option");
		
		driver.findElement(By.xpath(page_addemployee)).isDisplayed();
		Log.info("Add Employee modal exists ");
	}
	
	public static void clickUsers() {
		driver.findElement(By.xpath(menu_admin)).click();
		Log.info("Admin menu is clicked");
		
		driver.findElement(By.xpath(link_userManagement)).click();
		Log.info("User Management option is clicked");
		
		driver.findElement(By.xpath(link_users)).click();
		Log.info("Useres option is clicked");
	}
	
}
