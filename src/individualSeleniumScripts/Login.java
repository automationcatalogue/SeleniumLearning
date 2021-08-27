package individualSeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		System.out.println("Click action is performed on Login link");
		
		String cssValue=driver.findElement(By.xpath("//a[text()='Log in']")).getCssValue("font");
		System.out.println("cssValue is :"+cssValue);
		
		WebElement element_RemmemberMeChkBox=driver.findElement(By.id("RememberMe"));
		
		if(element_RemmemberMeChkBox.isSelected()){
			System.out.println("Remember Me check-box is already selected");
		}else{			
			element_RemmemberMeChkBox.click();
			System.out.println("Click action is performed on Remember Me Check-box");
		}
		
		String text=driver.findElement(By.xpath("//div[@class='page login-page']/div/h1")).getText();
		System.out.println("Login page text is :"+text);
		
		String value=driver.findElement(By.xpath("//a[text()='Forgot password?']")).getAttribute("href");
		System.out.println("Forgot password link href value is :"+value);
		
		String tagValue=driver.findElement(By.xpath("//span[text()='Shopping cart']")).getTagName();
		System.out.println("tagValue is :"+tagValue);
		
		int xposition=driver.findElement(By.xpath("//span[text()='Shopping cart']")).getLocation().getX();
		System.out.println("xposition of shopping cart is :"+xposition);
		
		int yposition=driver.findElement(By.xpath("//span[text()='Shopping cart']")).getLocation().getY();
		System.out.println("yposition of shopping cart is :"+yposition);
		
		int height=driver.findElement(By.xpath("//span[text()='Shopping cart']")).getSize().getHeight();
		System.out.println("Height of the web element is :"+height);
		
		int width=driver.findElement(By.xpath("//span[text()='Shopping cart']")).getSize().getWidth();
		System.out.println("width of the web element is :"+width);
		
		
		
		
	}

}
