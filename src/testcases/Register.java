package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {
	
	static WebDriver driver;
		
	public static void openBrowser(){
		System.setProperty("webdriver.chrome.driver","C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");

		 driver=new ChromeDriver();

		driver.get("http://demowebshop.tricentis.com");
		System.out.println("Website loaded");

		driver.manage().window().maximize();
		System.out.println("Browser window maximized");
	}

	public static void register() {
		
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		System.out.println("Selectd register button");

		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		System.out.println("Gender selected");

		driver.findElement(By.name("FirstName")).sendKeys("Vijetha");
		System.out.println("First name entered");

		driver.findElement(By.id("LastName")).sendKeys("Godbole");
		System.out.println("Last name entered");

		driver.findElement(By.id("Email")).sendKeys("log-in123@gmail.com");
		System.out.println("Email id entered");

		driver.findElement(By.name("Password")).sendKeys("login@123");
		System.out.println("password entered");

		driver.findElement(By.id("ConfirmPassword")).sendKeys("login@123");
		System.out.println("confiem password entered");

		driver.findElement(By.id("register-button")).click();
		System.out.println("Register button selected");

		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		System.out.println("Successfully registered and logged out");
  }
}
