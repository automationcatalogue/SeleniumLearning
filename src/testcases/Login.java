package testcases;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login {
	
	public static void login() throws Exception{
		
		Register.driver.findElement(By.className("ico-login")).click();
		System.out.println("Login button clicked");
		
		FileInputStream ob=new FileInputStream("C:\\Users\\vijetha\\eclipse-workspace\\Selenium Learning\\Test data\\Credentials.xlsx");
		XSSFWorkbook wbk=new XSSFWorkbook(ob);
		
		Register.driver.findElement(By.id("Email")).sendKeys("log-in123@gmail.com");
		System.out.println("Email Id enteed");
		
		Register.driver.findElement(By.id("Password")).sendKeys("login@123");
		System.out.println("Entered password");
		
		Register.driver.findElement(By.xpath("//input[@value='Log in']")).click();
		System.out.println("clicked on Login button");
		
	}

}
