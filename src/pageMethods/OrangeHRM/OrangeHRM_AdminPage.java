package pageMethods.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageMethods.BaseClass;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;

public class OrangeHRM_AdminPage {
	
	public static final String edituser="(//table[@class='highlight bordered']//td[8]/i[contains(text(),'ohrm_edit')])[1]";
	public static final String link_changePassword = "//label[@for='changepassword']";
	public static final String txtbox_password="//input[@id='password']";
	public static final String txtbox_confirmPassword="//input[@id='confirmpassword']";
	public static final String btn_save="//button[text()='Save']";
	
	public static void changePassword() throws Exception{
		WebElement edit = BaseClass.getDriver().findElement(By.xpath(edituser));
		edit.click();
		Log.info("Edit user option is clicked");

		
		BaseClass.getDriver().findElement(By.xpath(link_changePassword)).click();
		
		String new_password = ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Password, "OrangeHRM");
		
		BaseClass.getDriver().findElement(By.xpath(txtbox_password)).sendKeys(new_password);
		Log.info("New password is entered ");
		
		BaseClass.getDriver().findElement(By.xpath(txtbox_confirmPassword)).sendKeys(new_password);
		Log.info("Confirm password is entered ");
		
		Thread.sleep(3000);
		
		WebElement element_saveBtn=BaseClass.getDriver().findElement(By.xpath(btn_save));
		((JavascriptExecutor)BaseClass.getDriver()).executeScript("arguments[0].click();", element_saveBtn);
		Log.info("Save button is clicked");
		
	}
}
