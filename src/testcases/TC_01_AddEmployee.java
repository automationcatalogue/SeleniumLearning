package testcases;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Utility;


public class TC_01_AddEmployee {
	public static void main(String[] args) throws Exception {
		
		String path=System.getProperty("user.dir");
		System.out.println(path);
		
		ExcelUtilities.setExcelFile(path+"\\TestData\\TestData.xlsx");
		
		String un,pwd,fn,mn,ln,data,ms,g;
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testseleniumcod-trials72.orangehrmlive.com");
		System.out.println("Website is loaded");
		driver.manage().window().maximize();
		System.out.println("Window is maximized");
		Thread.sleep(2000);
		
		
		String userName=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_UserName, "OrangeHRM");
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		System.out.println(userName+" is entered as UserName in a text-box");
		
		String password = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Password, "OrangeHRM");
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		System.out.println(password+" is entered as Password in a text-box");
		
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("Login button is clicked");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		System.out.println("Selected PIM");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
		System.out.println("Selected add employee option");
		
		Thread.sleep(13000);
		fn=Constant.firsname;
		mn=Constant.middlename;
		ln=Constant.lastname;
		
		driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
		System.out.println("Add Employee modal exists ");
		Thread.sleep(8000);

		driver.findElement(By.xpath("//div[@class='input-group']/input[1]")).sendKeys(fn);
		System.out.println("First name is enered");
		
		driver.findElement(By.xpath("//div[@class='input-group']/input[2]")).sendKeys(mn);
		System.out.println("Middle name is enetered");
		
		driver.findElement(By.xpath("//div[@class='input-group']/input[3]")).sendKeys(ln);
		System.out.println("Last name is enetered");
		
		//String emp_id=driver.findElement(By.xpath("//input[@id='employeeId']")).getText();
		//System.out.println(emp_id);
		
		driver.findElement(By.xpath("//i[text()='arrow_drop_down']")).click();
		System.out.println("Location dropdown button clicked");
		
		int location_size=driver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']/li/a/span")).size();
		System.out.println("Number of locations available:" + location_size);
		
//		List<WebElement> elements_location=driver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']/li/a/span"));
//
//		data=Constant.data_location;
//		for(WebElement location:elements_location) {
//			String text_location=location.getText();
//			
//			if (text_location.equalsIgnoreCase(data)) {
//				location.click();
//				System.out.println(text_location + " Is selected from the dropdown");
//			}
//		}
		
		Utility.selection_dropdown(driver, "//ul[@class='dropdown-menu inner show']/li/a/span", Constant.data_location);
		driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();
		System.out.println("Next button clicked");
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@id='personal_details_tab']")).isDisplayed();
		System.out.println("Personal details page is displayed");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='otherId']")).sendKeys("JJ123");
		System.out.println("Entered data in other Id field");
		
		WebElement element_nationality_dd=driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_nationality_dd);
		System.out.println("Nationality drop-down is clicked");
				
		Thread.sleep(2000);
		Utility.selection_dropdown(driver, "//div[@id='nation_code_inputfileddiv']/div/ul/li/span",Constant.Nationality);
		System.out.println("Nationality of the employee is selected ");
		
		int elements_marital_status=driver.findElements(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//following-sibling::ul/li/span")).size();
		System.out.println("Option under marital status are " + elements_marital_status);
			
		WebElement element_maritalstatus_dd1=driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_maritalstatus_dd1);
		System.out.println("marital status drop-down is clicked");
		
		Thread.sleep(2000);
		
//		List<WebElement> element_mstatus=driver.findElements(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//following-sibling::ul/li/span"));
//		ms=Constant.marital_status;
//
//		for (WebElement maritalstatus:element_mstatus) {
//			String m=maritalstatus.getText();
//			
//			if (m.equalsIgnoreCase(ms)) {
//				maritalstatus.click();
//				System.out.println("Marital status selected as " + m);
//				break;
//			}
//		}
		
		Utility.selection_dropdown(driver, "//div[@id='emp_marital_status_inputfileddiv']//following-sibling::ul/li/span", Constant.marital_status);
		
		Thread.sleep(2000);
		
		WebElement element_gender_dd=driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_gender_dd);
		System.out.println("Gender drop-down is clicked");
		
		
		
//		List<WebElement> element_gstatus=driver.findElements(By.xpath("//div[@id='emp_gender_inputfileddiv']/div/ul/li/span"));
//		g=Constant.Gender;
//
//		for (WebElement genderfield:element_gstatus) {
//			String G=genderfield.getText();
//			
//			if (G.equalsIgnoreCase(g)) {
//				genderfield.click();
//				System.out.println("Gender is selected as " + G);
//				break;
//			}
//		}
		
		Utility.selection_dropdown(driver, "//div[@id='emp_gender_inputfileddiv']/div/ul/li/span", Constant.Gender);
		System.out.println("Gender is selcted as : Female");
		
/*		WebElement element_checkbox=driver.findElement(By.xpath("//div[@sf-message='form.description']"));
		
		if (!element_checkbox.isSelected()) {
			element_checkbox.click();
			System.out.println("Smoker checkbox is selected");
		}else {
			System.out.println("Soker checkbox is already selected");
		}*/
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Hobbies']//preceding-sibling::input")).sendKeys("Reading novels");
		System.out.println("Data entered in hobbies field");
		
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		System.out.println("Next button is clicked");
		Thread.sleep(10000);
		
		driver.findElement(By.id("employement_details_tab")).isDisplayed();
		System.out.println("Employee details page is displayed");
		Thread.sleep(3000);
		
		WebElement element_region_dd=driver.findElement(By.xpath("//div[@id='9_inputfileddiv']/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_region_dd);
		System.out.println("Region drop-down is clicked");
		
		Utility.selection_dropdown(driver,"//div[@id='9_inputfileddiv']/div/ul/li/span",Constant.Region);
		System.out.println("Region-2 is selcted from the dropdown");
		Thread.sleep(2000);
		
		WebElement element_FTE_dd=driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_FTE_dd);
		System.out.println("FTE drop-down is clicked");
		
		Utility.selection_dropdown(driver,"//div[@id='10_inputfileddiv']/div/ul/li/span",Constant.FTE);
		System.out.println("FTE is selected from the dropdown");
		Thread.sleep(5000);
		
		WebElement element_tempdept_dd=driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_tempdept_dd);
		System.out.println("Temporary department drop-down is clicked");
		
		Utility.selection_dropdown(driver,"//div[@id='11_inputfileddiv']/div/ul/li/span", Constant.Temporary_Department);
		System.out.println("Temporary department is selected  from the dropdown");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		System.out.println("Save button is clicked");
		Thread.sleep(12000);
		
		boolean personaldetails_tab=driver.findElement(By.xpath("(//div[@class='pim-container'])[2]")).isDisplayed();
		
		if (personaldetails_tab) {
			System.out.println("personal_details_page is displayed");
		}
		Thread.sleep(2000);
		WebElement save_btn=driver.findElement(By.xpath("(//button[text()='save'])[1]"));		
		
		Actions action=new Actions(driver);
		action.click(save_btn).build().perform();
		System.out.println("save buttonn is clicked");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[@ng-repeat='item in form.titleMap'])[1]")).click();
		System.out.println("Food selection radio button is clicked");
		
		Thread.sleep(4000);
		WebElement save_btn1=driver.findElement(By.xpath("(//button[text()='save'])[2]"));		
		
		Actions action1=new Actions(driver);
		action1.click(save_btn1).build().perform();
		System.out.println("save button is clicked");
		Thread.sleep(2000);
		
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, -250)");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Employee List']")).click();
		System.out.println("Emloyee list is seleced");
		
		String employee_name= Constant.firsname + " ".concat(Constant.middlename) + " ".concat(Constant.lastname); 
		System.out.println("Employee full name is " + employee_name);
		
		driver.findElement(By.xpath("//input[@placeholder='Employee Name']")).sendKeys(employee_name);
		System.out.println("Employee name entered in search tab");
		
		driver.findElement(By.xpath("//input[@placeholder='Employee Name']")).sendKeys(Keys.ARROW_DOWN);
		System.out.println("Employee selected from the dropdown");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Employee Name']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//td[text()='0157']")).getText();
		
	}

}
