package individualSeleniumScripts;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Constant;

public class JSDemo {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.gecko.driver", "C:\\Automation Catalogue\\Drivers\\FF\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		

		FileInputStream fis = new FileInputStream(Constant.testDataPath);
		
		XSSFWorkbook wbk = new XSSFWorkbook(fis);
		XSSFSheet sheet=wbk.getSheet("OrangeHRM");
		XSSFRow row=sheet.getRow(Constant.rownNmber);
		XSSFCell cell =row.getCell(Constant.col_UserName);
		String username=cell.getStringCellValue();
		
		String password =sheet.getRow(Constant.rownNmber).getCell(Constant.col_Password).getStringCellValue();
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.location=\'http://demowebshop.tricentis.com/'");
		System.out.println("Demo Webshop website is loaded");
		Thread.sleep(4000);
		WebElement element_login_link=driver.findElement(By.xpath("//a[text()='Log in']"));
		js.executeScript("arguments[0].click();", element_login_link);
		System.out.println("Login link is clicked");
		
		Thread.sleep(2000);
		js.executeScript("document.getElementById('Email').value='"+username+"'");
		System.out.println("Email ID is entered");
		
		WebElement element_password= driver.findElement(By.className("password"));
		js.executeScript("arguments[0].value='"+password+"';", element_password);
		System.out.println("Password is entered");
		
		WebElement element_login_btn=driver.findElement(By.xpath("//input[@value='Log in' and @type='submit']"));
		js.executeScript("arguments[0].click();", element_login_btn);
		System.out.println("Login button is clicked");
		
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		System.out.println("Vertically Scrolled till the bottom of a page");
		Thread.sleep(3000);
		//js.executeScript("window.scrollBy(0, -100)");
		//System.out.println("Vertically scrolled up by 100 pixels");
		
		WebElement element_display=driver.findElement(By.xpath("(//div[@class='page-body']/div[3]/div)[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element_display);
		Thread.sleep(2000);
		js.executeScript("history.go(0)");
		System.out.println("Browser is refreshed");
		
		Thread.sleep(2000);
		String title=js.executeScript("return document.title;").toString();
		System.out.println("title of the browser is :"+title);
		
		Thread.sleep(2000);
		String url=js.executeScript("return document.URL;").toString();
		System.out.println("URL is :"+url);
		
		Thread.sleep(2000);
		String domain = js.executeScript("return document.domain;").toString();
		System.out.println("Domain name is :"+domain);
		
	}
	
	
}
