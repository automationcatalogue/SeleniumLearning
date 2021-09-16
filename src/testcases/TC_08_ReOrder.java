package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Constant;
import utilities.ExcelUtilities;

public class TC_08_ReOrder {
	 
static WebDriver driver;
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
	}
	
	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://demowebshop.tricentis.com");
		System.out.println("Website loaded");

		driver.manage().window().maximize();
		System.out.println("Browser window maximized");
	}
	
	@Test
	
	public void re_Order() throws Exception{
		
		driver.findElement(By.className("ico-login")).click();
		Reporter.log("Login button is clicked", true);
		
		String email=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Email, "DemoWebShop");
		
		driver.findElement(By.id("Email")).sendKeys(email);
		Reporter.log("Email Id is entered",true);
		
		String password=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_Password, "DemoWebShop");
		driver.findElement(By.id("Password")).sendKeys(password);
		Reporter.log("Entered password", true);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("clicked on Login button", true);
		
		driver.findElement(By.xpath("//a[text()='aarosagarch@gmail.com']")).click();
		Reporter.log("Clicked on email name", true);
		
		driver.findElement(By.xpath("//ul[@class='list']/li[3]/a")).click();
		Reporter.log("Orders selcted from the options", true);
		
		List<WebElement> orders = driver.findElements(By.xpath("//div[@class='order-list']"));
        
         for(int i=0;i<orders.size();i++){
            
        	 String order_number=orders.get(i).findElement(By.xpath("//div[@class='title']//strong[contains(text(),'Order Number')]")).getText();

        	 Reporter.log(order_number);

             if(order_number.contentEquals("Order Number: 997040")){

            	 orders.get(i).findElement(By.xpath("(//input[@value='Details'])[3]")).click();
            	 Reporter.log("Order details button is clicked", true);
             }
         }
	}
}
