package orangehrm.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Constant;

public class AddEmployee {
	public static void main(String[] args) throws Exception{
		
		String un, pwd, data;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testsautomation-trials71.orangehrmlive.com");
		driver.manage().window().maximize();
		
		un=Constant.username;
		driver.findElement(By.id("txtUsername")).sendKeys(un);
		
		pwd=Constant.password;
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		System.out.println(pwd+" is the password is entered in a text-box");
		
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(8000);
		
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		System.out.println("Click action is performed on PIM menu");
		
		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
		System.out.println("Click action is performed on Add Employee link");
		
		Thread.sleep(12000);
		driver.findElement(By.xpath("//i[text()='arrow_drop_down']")).click();
		System.out.println("Click action is performed on Locations drop-down button");
		
		int size_locations=driver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']/li/a/span")).size();
		System.out.println("Number of locations in a drop-down is :"+size_locations);
		
		List<WebElement> elements_locations=driver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']/li/a/span"));
		
		data=Constant.Data_Location;
		//By using Advanced for loop
//		for(WebElement location:elements_locations){
//			String text_location=location.getText();
//			
//			if(text_location.equalsIgnoreCase(data)){
//				location.click();
//				System.out.println(text_location+" is selcted from the locations drop-down");
//				break;
//			}
//			
//		}
		
		//Regular for loop
		for(int location_number=1;location_number<=size_locations;location_number++){
			
			String actual_location=driver.findElement(By.xpath("//ul[@class='dropdown-menu inner show']/li["+location_number+"]/a/span")).getText();
			if(actual_location.equalsIgnoreCase(data)){
				driver.findElement(By.xpath("//ul[@class='dropdown-menu inner show']/li["+location_number+"]/a/span")).click();
				System.out.println(data+" is selcted from the locations drop-down");
				break;
			}
		}
		
	}
}
