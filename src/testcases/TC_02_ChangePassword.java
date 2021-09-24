package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Utility;

public class TC_02_ChangePassword {
	
static WebDriver driver;
static SoftAssert assertion;
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
		assertion = new SoftAssert();

	}
	
	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void change_password() throws Exception {
		
		driver.get("https://testseleniumcod-trials72.orangehrmlive.com");
		Reporter.log("Orange HRM website is loaded", true);
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized", true);
		
		
		String userName=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_UserName, "OrangeHRM");
		String password = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Password, "OrangeHRM");
		
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		Reporter.log("userName is entered in the text-box", true);
		
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		Reporter.log("password is entered in the text-box", true);
		
		driver.findElement(By.id("btnLogin")).click();
		Reporter.log("Login button is clicked",true);
		
		driver.findElement(By.xpath("(//span[text()='Admin'])[1]")).click();
		Reporter.log("Admin menu is clicked", true);
		
		driver.findElement(By.xpath("//span[text()='User Management']")).click();
		Reporter.log("User Management option is clicked", true);
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		Reporter.log("Useres option is clicked",true);
		
		WebElement edit = driver.findElement(By.xpath("(//table[@class='highlight bordered']//td[8]/i[contains(text(),'ohrm_edit')])[1]"));
		edit.click();
		Reporter.log("Edit user option is clicked",true);

		
		driver.findElement(By.xpath("//label[@for='changepassword']")).click();
		
		String new_password = ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Password, "OrangeHRM");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(new_password);
		Reporter.log("New password is entered ", true);
		
		driver.findElement(By.xpath("//input[@id='confirmpassword']")).sendKeys(new_password);
		Reporter.log("Confirm password is entered ", true);
		
		Thread.sleep(3000);
		
		WebElement element_saveBtn=driver.findElement(By.xpath("//button[text()='Save']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_saveBtn);
		Reporter.log("Save button is clicked", true);
		
		WebElement dropdown_logout = driver.findElement(By.xpath("//i[text()='keyboard_arrow_down']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",dropdown_logout);
		Reporter.log("Logout dropdown is clicked", true);
		
		String logout=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.options, "OrangeHRM");
		WebElement element_logoutBtn=driver.findElement(By.xpath("//ul[@id='user_menu']//li[3]/a"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_logoutBtn);
		Reporter.log(logout+ " is selected from the dropdown",true);
		
	
		String newuserName=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_UserName, "OrangeHRM");
		String newpassword = ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Password, "OrangeHRM");
		
		driver.findElement(By.id("txtUsername")).sendKeys(newuserName);
		Reporter.log(newuserName+" is entered as UserName in a text-box", true);
		
		driver.findElement(By.name("txtPassword")).sendKeys(newpassword);
		Reporter.log(newpassword+" is entered as Password in a text-box", true);
		
		driver.findElement(By.id("btnLogin")).click();
		Reporter.log("Login button is clicked",true);
		
		Thread.sleep(4000);
		
		WebElement dropdown_logout1 = driver.findElement(By.xpath("//i[text()='keyboard_arrow_down']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",dropdown_logout1);
		Reporter.log("Logout dropdown is clicked", true);
		
		String logout1=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.options, "OrangeHRM");
		WebElement element_logoutBtn1=driver.findElement(By.xpath("//ul[@id='user_menu']//li[3]/a"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_logoutBtn1);
		Reporter.log("Successfully logged out of the website",true);
		
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
		Reporter.log("Browser is closed");
		assertion.assertAll();
	}
}	
