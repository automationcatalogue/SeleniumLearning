package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.ExcelUtilities;

public class Register {
	
	static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
	}
	
	@BeforeMethod
	public static void openBrowser(){

		 driver=new ChromeDriver();

		driver.get("http://demowebshop.tricentis.com");
		System.out.println("Website loaded");

		driver.manage().window().maximize();
		System.out.println("Browser window maximized");
	}
	
	@Test
	public static void register() {
		
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		System.out.println("Selectd register button");

		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		System.out.println("Gender selected");

		driver.findElement(By.name("FirstName")).sendKeys("Vijetha");
		System.out.println("First name entered");

		driver.findElement(By.id("LastName")).sendKeys("Godbole");
		System.out.println("Last name is entered");

		driver.findElement(By.id("Email")).sendKeys("log-in123@gmail.com");
		System.out.println("Email id is entered in the text-box");

		driver.findElement(By.name("Password")).sendKeys("login@123");
		System.out.println("password is entered in the text-box");

		driver.findElement(By.id("ConfirmPassword")).sendKeys("login@123");
		System.out.println("password entered in confirm password text-box");

		driver.findElement(By.id("register-button")).click();
		System.out.println("Register button selected");

		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		System.out.println("Successfully registered and logged out");
  }
}
