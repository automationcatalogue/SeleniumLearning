package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		System.out.println("Website loaded");

		driver.manage().window().maximize();
		System.out.println("Browser window maximized");
	}
	
	
	@Test
	public static void register() throws Exception {
		
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		System.out.println("Selectd register button");

		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		System.out.println("Gender selected");
		
		String firstname =RandomGenerator.randomAlphabet(5, 7);
		driver.findElement(By.name("FirstName")).sendKeys(firstname);
		ExcelUtilities.setCellData(firstname, Constant.iRowNumber, Constant.col_Firstname, "DemoWebShop", excelPath);
		System.out.println("First-name entered");

		String lastname =RandomGenerator.randomAlphabet(5, 7);
		driver.findElement(By.id("LastName")).sendKeys(lastname);
		ExcelUtilities.setCellData(lastname, Constant.iRowNumber, Constant.col_Lastname, "DemoWebShop", excelPath);
		System.out.println("Last name is entered");
				
		String Email =RandomGenerator.randomAlphabet(8,10)+"@gmail.com";
		driver.findElement(By.id("Email")).sendKeys(Email);
		ExcelUtilities.setCellData(Email, Constant.iRowNumber, Constant.col_email, "DemoWebShop", excelPath);
		System.out.println("Email id is entered in the text-box");

		String Password = ExcelUtilities.getCellData(Constant.iRowNumber,Constant.col_password, "DemoWebShop");
		driver.findElement(By.name("Password")).sendKeys(Password);
		System.out.println("password is entered in the text-box");

		driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
		System.out.println("password entered in confirm password text-box");

		driver.findElement(By.id("register-button")).click();
		System.out.println("Register button selected");
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		System.out.println("Successfully logged out post registration");
  }
	@AfterClass
	public void teardown() {
		driver.quit();
		Reporter.log("Browser is closed");
		assertion.assertAll();
	}
}
