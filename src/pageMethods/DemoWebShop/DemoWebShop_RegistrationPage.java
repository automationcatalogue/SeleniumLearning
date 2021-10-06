package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageMethods.BaseClass;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.RandomGenerator;

public class DemoWebShop_RegistrationPage {
	static WebDriver driver=BaseClass.getDriver();
	public static final String rbtn_genderM="//input[@id='gender-male']";
	public static final String rbtn_genderF="//input[@id='gender-female']";
	public static void register(String excelPath) throws Exception{
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		Log.info("Register button is clicked");

		String Gender=ExcelUtilities.getCellData(Constant.iRowNumber,Constant.col_gender ,"DemoWebShop");
		
		if(Gender.equalsIgnoreCase("Male")) {
			driver.findElement(By.xpath(rbtn_genderM)).click();
			Log.info("Gender is selected as: "+ Gender);
		}else if (Gender.equalsIgnoreCase("Female")) {
			driver.findElement(By.xpath(rbtn_genderF)).click();
			Log.info("Gender is selected as :" +Gender);
		}else {
			Log.error("Gender data provided in excel is invaid");
		}
		
		String firstname =RandomGenerator.randomAlphabet(5, 7);
		driver.findElement(By.name("FirstName")).sendKeys(firstname);
		ExcelUtilities.setCellData(firstname, Constant.iRowNumber, Constant.col_Firstname, "DemoWebShop", excelPath);
		Log.info("First-name is entered");

		String lastname =RandomGenerator.randomAlphabet(5, 7);
		driver.findElement(By.id("LastName")).sendKeys(lastname);
		ExcelUtilities.setCellData(lastname, Constant.iRowNumber, Constant.col_Lastname, "DemoWebShop", excelPath);
		Log.info("Last name is entered");
				
		String Email =RandomGenerator.randomAlphabet(8,10)+"@gmail.com";
		driver.findElement(By.id("Email")).sendKeys(Email);
		ExcelUtilities.setCellData(Email, Constant.iRowNumber, Constant.col_email, "DemoWebShop", excelPath);
		Log.info("Email id is entered");

		String Password = ExcelUtilities.getCellData(Constant.iRowNumber,Constant.col_password, "DemoWebShop");
		driver.findElement(By.name("Password")).sendKeys(Password);
		Log.info("password is entered");

		driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
		Log.info("password entered in confirm password text-box");

		driver.findElement(By.id("register-button")).click();
		Log.info("Register button is selected");
	}
}
