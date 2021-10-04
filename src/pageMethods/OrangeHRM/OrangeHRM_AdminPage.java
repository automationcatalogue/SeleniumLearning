package pageMethods.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;

public class OrangeHRM_AdminPage {
	static WebDriver driver;
	
	public static void changePassword() throws Exception{
		WebElement edit = driver.findElement(By.xpath("(//table[@class='highlight bordered']//td[8]/i[contains(text(),'ohrm_edit')])[1]"));
		edit.click();
		Log.info("Edit user option is clicked");

		
		driver.findElement(By.xpath("//label[@for='changepassword']")).click();
		
		String new_password = ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Password, "OrangeHRM");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(new_password);
		Log.info("New password is entered ");
		
		driver.findElement(By.xpath("//input[@id='confirmpassword']")).sendKeys(new_password);
		Log.info("Confirm password is entered ");
		
		Thread.sleep(3000);
		
		WebElement element_saveBtn=driver.findElement(By.xpath("//button[text()='Save']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_saveBtn);
		Log.info("Save button is clicked");
		
	}
}
