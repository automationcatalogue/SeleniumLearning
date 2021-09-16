package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_11_AirbnbValidation {
	
	static WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void priceRangeFilter() throws Exception {
		
		driver.get("https://www.airbnb.co.in/?locale=en&_set_bev_on_new_domain=1626060086_MDkyYzhmZTgxNzlh");
		Reporter.log("Airbnb website is loaded",true);
		
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized", true);
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Reporter.log("Accepted the cookies", true);
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Where are you going')]")).click();
		Reporter.log("Location is clicked ", true);
		
		driver.findElement(By.xpath("//div[text()='I’m flexible']")).click();
		Reporter.log("I’m flexible button is clicked", true);
		
		driver.findElement(By.xpath("//div[@id='search-results-container']")).isDisplayed();
		Reporter.log("Search results are displayed",true);
		
		driver.findElement(By.xpath("(//span[text()='Guests'])[1]")).click();
		Reporter.log("Guests dropdown is clicked", true);
		
		WebElement element_adults=driver.findElement(By.xpath("(//button[@aria-label='increase value'])[1]"));
		
		Actions action_click=new Actions(driver);
		action_click.click(element_adults).click(element_adults).build().perform();
		Reporter.log("No of adults selected from filter : 2", true);
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Reporter.log("Saved selection",true);
		
		driver.findElement(By.xpath("//button[contains(@aria-label,'Filters')]/div/div")).click();
		Reporter.log("Filters button is clicked", true);
		
		WebElement checkbox=driver.findElement(By.xpath("//input[@name='Entire place']"));
		if (!checkbox.isSelected()) {
			checkbox.click();
			Reporter.log("Entire place checkbox is selected", true);
		}else {
			Reporter.log("Entire place checkbox is already selected", true);
		}
		
		WebElement checkbox1=driver.findElement(By.xpath("//input[@name='Hotel room']"));
		if (!checkbox1.isSelected()) {
			checkbox1.click();
			Reporter.log("Hotel room checkbox is selected", true);
		}else {
			Reporter.log("checkbox is already selected",true);
		}
		
		WebElement verified_switch=driver.findElement(By.xpath("(//button[@role='switch'])[1]"));
//		boolean abc=verified_switch.isEnabled();
//		boolean xyz=verified_switch.isSelected();
//		System.out.println(abc);
//		System.out.println(xyz);
		if (verified_switch.isSelected()) {
			verified_switch.click();
			Reporter.log("Airbnb switch is disabled", true);
		}else {
			Reporter.log("Airbnb switch is already disabled", true);
		}
		
		int expected_maxPrice=35000;
		WebElement Maxprice_btn=driver.findElement(By.xpath("//button[@aria-label='Maximum Price']"));
		//WebElement element_MaxPrice=driver.findElement(By.xpath("//input[@id='price_filter_max']"));
		
		Actions movepointerleft=new Actions(driver);
		int actual_maxprice=50000;
		while(actual_maxprice>=expected_maxPrice) {
			
			movepointerleft.clickAndHold(Maxprice_btn).moveByOffset(-50, 0).release().build().perform();
			String actualString_maxprice=Maxprice_btn.getAttribute("aria-valuenow");
			actual_maxprice=Integer.parseInt(actualString_maxprice);
			if(actual_maxprice<=expected_maxPrice) {
				Reporter.log("Final Actual max price is :"+actual_maxprice, true);
				break;
			}
		}
		
		int expected_minprice=3000;
		WebElement Minprice_btn=driver.findElement(By.xpath("//button[@aria-label='Minimum Price']"));
		
		Actions movepointerright= new Actions(driver);
		int actual_minprice=750;
		
		while(actual_minprice<=expected_minprice) {
			movepointerright.clickAndHold(Minprice_btn).moveByOffset(50,0).release().build().perform();
			String actualString_minprice=Minprice_btn.getAttribute("aria-valuenow");
			actual_minprice=Integer.parseInt(actualString_minprice);
			if (actual_minprice>=expected_minprice) {
				Reporter.log("Final actual min price is " + actual_minprice, true);
				break;
			}
		}
		
		WebElement bedroom_btn=driver.findElement(By.xpath("(//button[@aria-label='increase value'])[2]"));
		Actions increase_btn=new Actions(driver);
		increase_btn.click(bedroom_btn).build().perform();
		Reporter.log("Number of bedrooms set to one", true);
		
		driver.findElement(By.xpath("//button[text()='Show 300+ stays']")).click();
		Reporter.log("Show listings button is clicked", true);
		
		List<WebElement> element_price=driver.findElements(By.xpath("//div[@itemprop='itemList']//following::div[@class='_1i1hiso']/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/span[1]"));
		int size= element_price.size();
		//Reporter.log(size);
		
		for (WebElement element:element_price) {
			String price=element.getText();
			price=price.replace(",","");
			price=price.substring(1);
			Reporter.log("Price of the elements is "+ price, true);
			int pricevalue=Integer.parseInt(price);
			
			if (pricevalue>=actual_minprice && pricevalue<=actual_maxprice) {
				Reporter.log("Element price is beteen the range", true);
			}else {
				Reporter.log("Element price is not within the range", true);
				throw new Exception();
			}
		}
	}
	
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
	
}
