package testcases;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.ExcelUtilities;


public class Login {
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
	}
	
	@Test
	public static void login() throws Exception{
		
		Register.driver.findElement(By.className("ico-login")).click();
		Reporter.log("Login button is clicked", true);
		
		Register.driver.findElement(By.id("Email")).sendKeys("log-in123@gmail.com");
		Reporter.log("Email Id is entered",true);
		
		Register.driver.findElement(By.id("Password")).sendKeys("login@123");
		Reporter.log("Entered password", true);
		
		Register.driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("clicked on Login button", true);
		
	}

}
