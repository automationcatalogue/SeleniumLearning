package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelUtilities;
import utilities.Utility;

public class Register {
	
	static WebDriver driver;
	static SoftAssert assertion;
	
	@BeforeClass
	public void setup() throws Exception {
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
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
	
	@Parameters({"email","password","firstname","lastname"})
	@Test
	public static void register(String email, String password, String firstname, String lastname) {
		
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		System.out.println("Selectd register button");

		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		System.out.println("Gender selected");

		driver.findElement(By.name("FirstName")).sendKeys(firstname);
		System.out.println("First-name entered");

		driver.findElement(By.id("LastName")).sendKeys(lastname);
		System.out.println("Last name is entered");

		driver.findElement(By.id("Email")).sendKeys(email);
		System.out.println("Email id is entered in the text-box");

		driver.findElement(By.name("Password")).sendKeys(password);
		System.out.println("password is entered in the text-box");

		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
		System.out.println("password entered in confirm password text-box");

		driver.findElement(By.id("register-button")).click();
		System.out.println("Register button selected");

		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		System.out.println("Successfully logged out post registration");
  }
}
