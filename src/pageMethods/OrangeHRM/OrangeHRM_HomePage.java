package pageMethods.OrangeHRM;

import org.openqa.selenium.By;
import pageMethods.BaseClass;
import utilities.Log;

public class OrangeHRM_HomePage {

	public static final String link_PIM="//span[text()='PIM']";
	public static final String link_addEmployee="//span[text()='Add Employee']";
	public static final String page_addemployee="//div[@class='modal-content']";
	public static final String menu_admin="(//span[text()='Admin'])[100]";
	public static final String link_userManagement="//span[text()='User Management']";
	public static final String link_users="//span[text()='Users']";
	
	public static void clickAddEmployee() {
		BaseClass.getDriver().findElement(By.xpath(link_PIM)).click();
		Log.info("Selected PIM from the available options");
		
		BaseClass.getDriver().findElement(By.xpath(link_addEmployee)).click();
		Log.info("Selected add employee option");
		
		BaseClass.getDriver().findElement(By.xpath(page_addemployee)).isDisplayed();
		Log.info("Add Employee modal exists ");
	}
	
	public static void clickUsers() {
		BaseClass.getDriver().findElement(By.xpath(menu_admin)).click();
		Log.info("Admin menu is clicked");
		
		BaseClass.getDriver().findElement(By.xpath(link_userManagement)).click();
		Log.info("User Management option is clicked");
		
		BaseClass.getDriver().findElement(By.xpath(link_users)).click();
		Log.info("Useres option is clicked");
	}
	
}
