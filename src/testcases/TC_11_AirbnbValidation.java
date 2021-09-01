package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_11_AirbnbValidation {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.airbnb.co.in/?locale=en&_set_bev_on_new_domain=1626060086_MDkyYzhmZTgxNzlh");
		System.out.println("Website is loaded");
		
		driver.manage().window().maximize();
		System.out.println("Window is maximized");
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		System.out.println("cookies accepted");
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Where are you going')]")).click();
		System.out.println("Location clicked ");
		
		driver.findElement(By.xpath("//div[text()='I’m flexible']")).click();
		System.out.println("I’m flexible button is clicked");
		//Thread.sleep(8000);
		
		driver.findElement(By.xpath("//div[@id='search-results-container']")).isDisplayed();
		System.out.println("Search results displayed");
		
		driver.findElement(By.xpath("(//span[text()='Guests'])[1]")).click();
		System.out.println("Guests dropdown is clicked");
		
		WebElement element_adults=driver.findElement(By.xpath("(//button[@aria-label='increase value'])[1]"));
		
		Actions action_click=new Actions(driver);
		action_click.click(element_adults).click(element_adults).build().perform();
		System.out.println("Slected 2 adults from filter");
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		System.out.println("Saved selection");
		//Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[contains(@aria-label,'Filters')]/div/div")).click();
		System.out.println("Filters button is clicked");
		//Thread.sleep(3000);
		
		WebElement checkbox=driver.findElement(By.xpath("//input[@name='Entire place']"));
		if (!checkbox.isSelected()) {
			checkbox.click();
			System.out.println("Entire place checkbox is selected");
		}else {
			System.out.println("checkbox is already selected");
		}
		
		WebElement checkbox1=driver.findElement(By.xpath("//input[@name='Hotel room']"));
		if (!checkbox1.isSelected()) {
			checkbox1.click();
			System.out.println("Hotel room checkbox is selected");
		}else {
			System.out.println("checkbox is already selected");
		}
		
		WebElement verified_switch=driver.findElement(By.xpath("(//button[@role='switch'])[1]"));
//		boolean abc=verified_switch.isEnabled();
//		boolean xyz=verified_switch.isSelected();
//		System.out.println(abc);
//		System.out.println(xyz);
		if (verified_switch.isSelected()) {
			verified_switch.click();
			System.out.println("Airbnb switch is disabled");
		}else {
			System.out.println("Airbnb switch is already disabled");
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
				System.out.println("Final Actual max price is :"+actual_maxprice);
				break;
			}
		}
		//Thread.sleep(2000);
		
		int expected_minprice=3000;
		WebElement Minprice_btn=driver.findElement(By.xpath("//button[@aria-label='Minimum Price']"));
		
		Actions movepointerright= new Actions(driver);
		int actual_minprice=750;
		
		while(actual_minprice<=expected_minprice) {
			movepointerright.clickAndHold(Minprice_btn).moveByOffset(50,0).release().build().perform();
			String actualString_minprice=Minprice_btn.getAttribute("aria-valuenow");
			actual_minprice=Integer.parseInt(actualString_minprice);
			if (actual_minprice>=expected_minprice) {
				System.out.println("Final actual min price is " + actual_minprice);
				break;
			}
		}
		//Thread.sleep(2000);
		
		WebElement bedroom_btn=driver.findElement(By.xpath("(//button[@aria-label='increase value'])[2]"));
		Actions increase_btn=new Actions(driver);
		increase_btn.click(bedroom_btn).build().perform();
		System.out.println("Number of bedrooms set to one");
		
		driver.findElement(By.xpath("//button[text()='Show 300+ stays']")).click();
		System.out.println("Show listings button is clicked");
		Thread.sleep(10000);
		
		List<WebElement> element_price=driver.findElements(By.xpath("//div[@itemprop='itemList']//following::div[@class='_1i1hiso']/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/span[1]"));
		int size= element_price.size();
		System.out.println(size);
		
		for (WebElement element:element_price) {
			String price=element.getText();
			price=price.replace(",","");
			price=price.substring(1);
			System.out.println("Price of the elements is "+ price);
			int pricevalue=Integer.parseInt(price);
			
			if (pricevalue>=actual_minprice && pricevalue<=actual_maxprice) {
				System.out.println("Element price is beteen the range");
			}else {
				System.out.println("Element price is not within the range");
				throw new Exception();
			}
		}
		
		
	}
}
