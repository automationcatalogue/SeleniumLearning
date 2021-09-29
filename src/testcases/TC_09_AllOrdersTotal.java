package testcases;

import java.util.ArrayList;
import java.util.List;
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
import utilities.Utility;

public class TC_09_AllOrdersTotal {

static WebDriver driver;
static SoftAssert assertion;
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
		assertion = new SoftAssert();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openBrowser(@Optional("Chrome") String browser) {
		
		Reporter.log("Browser Name from the TestNG.xml is :"+browser, true);
		driver=Utility.getDriver(browser);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://demowebshop.tricentis.com");
		Reporter.log("Website is successfully loaded", true);

		driver.manage().window().maximize();
		Reporter.log("Browser window maximized", true);
	}
	
	@Test
	
	public void allorders_total() throws Exception{
		//login
		driver.findElement(By.className("ico-login")).click();
		Reporter.log("Login button is clicked", true);
		
		String email=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Email, "DemoWebShop");
		driver.findElement(By.id("Email")).sendKeys(email);
		Reporter.log("Email Id is entered",true);
		
		String password=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Password, "DemoWebShop");
		driver.findElement(By.id("Password")).sendKeys(password);
		Reporter.log("Password is entered", true);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("Login button is clicked", true);
		
		//orders
		driver.findElement(By.xpath("//a[text()='aarosagarch@gmail.com']")).click();
		Reporter.log("Email name is clicked", true);
		
		driver.findElement(By.xpath("//ul[@class='list']/li[3]/a")).click();
		Reporter.log("Orders options is clicked", true);
		
		int totalorders = driver.findElements(By.xpath("//div[@class='order-list']/div")).size();
		Reporter.log("Total number of orders placed are:" + totalorders, true);
		
		
		List<WebElement> list_totalorders = driver.findElements(By.xpath("//div[@class='order-list']/div/ul/li[3]"));
		int sum=0;
		for(WebElement element_orderTotal:list_totalorders) {
			String orderTotal=element_orderTotal.getText();
			orderTotal=orderTotal.split(":")[1].trim().split("\\.")[0];
			int total=Integer.parseInt(orderTotal);
			sum=sum+total;
		}
		Reporter.log("Sum of Total orders is :"+sum , true);
		
		List<WebElement> list_totalorders_daywise=driver.findElements(By.xpath("//div[@class='order-list']/div/ul/li[2]"));
		for (WebElement daywise_list:list_totalorders_daywise) {
			String daywise_ordervalue=daywise_list.getText().split(" ")[2];
			//System.out.println(daywise_ordervalue);
			
			List<String> Totalorders_daywise= new ArrayList<String>();
			Totalorders_daywise.add(daywise_ordervalue);
			System.out.println(Totalorders_daywise);
		
			
		}
		
	}
	@AfterClass
	public void close_browser() {
		//driver.quit();
		Reporter.log("Browser is successfully closed", true);
		assertion.assertAll();
  }
}
	
