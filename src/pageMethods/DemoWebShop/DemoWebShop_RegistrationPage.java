package pageMethods.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.RandomGenerator;

public class DemoWebShop_RegistrationPage {
	static WebDriver driver;
	
	public static void register(String excelPath) throws Exception{
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		Reporter.log("Register button is clicked",true);

		String Gender=ExcelUtilities.getCellData(Constant.iRowNumber,Constant.col_gender ,"DemoWebShop");
		
		if(Gender.equalsIgnoreCase("Male")) {
			driver.findElement(By.xpath("//input[@id='gender-male']")).click();
			Reporter.log("Gender is selected as: "+ Gender,true);
		}else if (Gender.equalsIgnoreCase("Female")) {
			driver.findElement(By.xpath("//input[@id='gender-female']")).click();
			Reporter.log("Gender is selected as :" +Gender,true);
		}else {
			Reporter.log("Gender data provided in excel is invaid", true);
		}
		
		String firstname =RandomGenerator.randomAlphabet(5, 7);
		driver.findElement(By.name("FirstName")).sendKeys(firstname);
		ExcelUtilities.setCellData(firstname, Constant.iRowNumber, Constant.col_Firstname, "DemoWebShop", excelPath);
		Reporter.log("First-name is entered", true);

		String lastname =RandomGenerator.randomAlphabet(5, 7);
		driver.findElement(By.id("LastName")).sendKeys(lastname);
		ExcelUtilities.setCellData(lastname, Constant.iRowNumber, Constant.col_Lastname, "DemoWebShop", excelPath);
		Reporter.log("Last name is entered", true);
				
		String Email =RandomGenerator.randomAlphabet(8,10)+"@gmail.com";
		driver.findElement(By.id("Email")).sendKeys(Email);
		ExcelUtilities.setCellData(Email, Constant.iRowNumber, Constant.col_email, "DemoWebShop", excelPath);
		Reporter.log("Email id is entered", true);

		String Password = ExcelUtilities.getCellData(Constant.iRowNumber,Constant.col_password, "DemoWebShop");
		driver.findElement(By.name("Password")).sendKeys(Password);
		Reporter.log("password is entered", true);

		driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
		Reporter.log("password entered in confirm password text-box", true);

		driver.findElement(By.id("register-button")).click();
		Reporter.log("Register button is selected", true);
	}
}
