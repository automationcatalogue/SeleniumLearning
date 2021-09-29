package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.RandomGenerator;
import utilities.Utility;

public class TC_05_DemoWebShop_Register {
	
	static WebDriver driver;
	static SoftAssert assertion;
	static String excelPath;
	
	@BeforeClass
	public void setup() throws Exception {
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		excelPath=path+"\\TestData\\TestData.xlsx";
		ExcelUtilities.setExcelFile(excelPath);
		assertion = new SoftAssert();
	
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public static void openBrowser(@Optional("Chrome") String browser) {
		Reporter.log("Browser Name from the TestNG.xml is :"+browser);
		driver=Utility.getDriver(browser);
				
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.get("http://demowebshop.tricentis.com");
		Reporter.log("Website is successfully loaded", true);

		driver.manage().window().maximize();
		Reporter.log("Browser window maximized", true);
	}
	
	
	@Test
	public static void register() throws Exception {
		
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
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		Reporter.log("Successfully logged out post registration", true);
  }
	@AfterClass
	public void teardown() {
		driver.quit();
		Reporter.log("Browser is closed", true);
		assertion.assertAll();
	}
}
