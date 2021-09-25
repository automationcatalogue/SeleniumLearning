 package testcases;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.RandomGenerator;
import utilities.Utility;


public class TC_01_AddEmployee {
	
	static WebDriver driver;
	static SoftAssert assertion;
	static String excelPath;
	
	@BeforeClass
	public void setup() throws Exception{
		String path=System.getProperty("user.dir");
		Reporter.log("Path of the Project is :"+path, true);
		
		excelPath=path+"\\TestData\\TestData.xlsx";
		ExcelUtilities.setExcelFile(excelPath);
		assertion = new SoftAssert();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openBrowser(@Optional("Chrome") String browser) {
		Reporter.log("Browser Name from the TestNG.xml is :"+browser);
		driver=Utility.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void add_Employee() throws Exception {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		driver.get("https://testseleniumcod-trials72.orangehrmlive.com");
		Reporter.log("Orange HRM website is loaded", true);
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized", true);
		
		
		String userName=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_UserName, "OrangeHRM");
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		Reporter.log(userName+" is entered as UserName in a text-box", true);
		
		String password = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Password, "OrangeHRM");
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		Reporter.log(password+" is entered as Password in a text-box", true);
		
		driver.findElement(By.id("btnLogin")).click();
		Reporter.log("Login button is clicked",true);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[text()='Dashboard']")).isDisplayed());
		Reporter.log("Home page is displayed", true);
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Reporter.log("Selected PIM from the available options",true);
		
		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
		Reporter.log("Selected add employee option", true);
		
		driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
		Reporter.log("Add Employee modal exists ", true);
		
		//firstname
		String firstname =RandomGenerator.randomAlphabet(5, 8);
		driver.findElement(By.xpath("//div[@class='input-group']/input[1]")).sendKeys(firstname);
		ExcelUtilities.setCellData(firstname, Constant.RowNumber_five, Constant.col_Firstname, "OrangeHRM", excelPath);
		Reporter.log(firstname+ "First-name entered in the text-box", true);
		
		//middlename
		String middlename =RandomGenerator.randomAlphabet(3, 4);
		driver.findElement(By.xpath("//div[@class='input-group']/input[2]")).sendKeys(middlename);
		ExcelUtilities.setCellData(firstname, Constant.RowNumber_five, Constant.col_middlename, "OrangeHRM", excelPath);
		Reporter.log(middlename+ " is enered as middle name in the text-box", true);
		
		//lastname
		String lastname =RandomGenerator.randomAlphabet(3, 6);
		driver.findElement(By.xpath("//div[@class='input-group']/input[3]")).sendKeys(lastname);
		ExcelUtilities.setCellData(firstname, Constant.RowNumber_five, Constant.col_lastname, "OrangeHRM", excelPath);
		Reporter.log(lastname+ "is enered as  nalastme in the text-box", true);
		
		driver.findElement(By.xpath("//i[text()='arrow_drop_down']")).click();
		Reporter.log("Location dropdown button is clicked", true);
		
		//locations
		int location_size=driver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']/li/a/span")).size();
		Reporter.log("Number of locations available:" + location_size, true);
		
		String datalocation=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_datalocation, "OrangeHRM");
		Utility.selection_dropdown(driver, "//ul[@class='dropdown-menu inner show']/li/a/span", datalocation);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-secondary']")));
		Thread.sleep(1000);
		WebElement btn_Next=driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", btn_Next);
		Reporter.log("Next button is clicked", true);
		
		driver.findElement(By.xpath("//div[@id='personal_details_tab']")).isDisplayed();
		Reporter.log("Personal details page is displayed",true);
		
		driver.findElement(By.xpath("//input[@id='otherId']")).sendKeys("JJ123");
		Reporter.log("Entered data in other Id field",true);
		
		WebElement element_nationality_dd=driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_nationality_dd);
		Reporter.log("Nationality drop-down is clicked",true);
				
		String nationality=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Nationality, "OrangeHRM");
		Utility.selection_dropdown(driver, "//div[@id='nation_code_inputfileddiv']/div/ul/li/span",nationality);
		Reporter.log(nationality + " is selected as nationality of the employee",true);
		
		int elements_marital_status=driver.findElements(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//following-sibling::ul/li/span")).size();
		Reporter.log("Option under marital status are " + elements_marital_status,true);
			
		WebElement element_maritalstatus_dd1=driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_maritalstatus_dd1);
		Reporter.log("marital status drop-down is clicked",true);
		
		
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
		String maritalstatus=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_maritalstatus, "OrangeHRM");
		Utility.selection_dropdown(driver, "//div[@id='emp_marital_status_inputfileddiv']//following-sibling::ul/li/span",maritalstatus);
		
		
		WebElement element_gender_dd=driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_gender_dd);
		Reporter.log("Gender drop-down is clicked", true);
		
		
		
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
		
		String gender=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Gender, "OrangeHRM");

		Utility.selection_dropdown(driver, "//div[@id='emp_gender_inputfileddiv']/div/ul/li/span",gender);
		Reporter.log("Gender is selcted as :" + gender, true);
		
/*		WebElement element_checkbox=driver.findElement(By.xpath("//div[@sf-message='form.description']"));
		
		if (!element_checkbox.isSelected()) {
			element_checkbox.click();
			System.out.println("Smoker checkbox is selected");
		}else {
			System.out.println("Soker checkbox is already selected");
		}*/
		
		driver.findElement(By.xpath("//label[text()='Hobbies']//preceding-sibling::input")).sendKeys("Reading novels");
		Reporter.log("Data entered in hobbies field",true);
		
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		Reporter.log("Next button is clicked",true);
		
		Utility.waitForPageLoad(driver);
		Reporter.log("Employee details page is displayed",true);
				
		
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Save']")));
		Thread.sleep(1000);
		Utility.retryClick(driver, By.xpath("//label[contains(text(),'Region')]/..//following-sibling::input[1]"));
		Reporter.log("Region drop-down is clicked", true);
		Thread.sleep(1000);
		String Region=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Region, "OrangeHRM");
		Utility.selection_dropdown(driver,"//div[@id='9_inputfileddiv']/div/ul/li/span",Region);
		Reporter.log(Region+ " is selcted from the dropdown", true);
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[contains(text(),'FTE')]/..//following-sibling::input[1]")));
		Reporter.log("FTE drop-down is clicked", true);
		
		String FTE=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_FTE, "OrangeHRM");
		Utility.selection_dropdown(driver,"//div[@id='10_inputfileddiv']/div/ul/li/span",FTE);
		Reporter.log(FTE+ " is selected from the dropdown",true);
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[contains(text(),'Temporary')]/..//following-sibling::input[1]")));
		Reporter.log("Temporary department drop-down is clicked",true);
		Thread.sleep(1000);
		String TempDep=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_TempDepartment, "OrangeHRM");
		Utility.selection_dropdown(driver,"//div[@id='11_inputfileddiv']/div/ul/li/span", TempDep);
		Reporter.log(TempDep+ " is selected  from the dropdown", true);
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Reporter.log("Save button is clicked", true);
		
		assertion.assertTrue(driver.findElement(By.xpath("(//div[@class='pim-container'])[2]")).isDisplayed(),"Personal Details page is not displayed");
		
		WebElement save_btn=driver.findElement(By.xpath("(//button[text()='save'])[1]"));		
		
		Actions action=new Actions(driver);
		action.click(save_btn).build().perform();
		Reporter.log("save buttonn is clicked", true);
		
		driver.findElement(By.xpath("(//li[@ng-repeat='item in form.titleMap'])[1]")).click();
		Reporter.log("Food selection radio button is clicked", true);
		
		WebElement save_btn1=driver.findElement(By.xpath("(//button[text()='save'])[2]"));		
		
		Actions action1=new Actions(driver);
		action1.click(save_btn1).build().perform();
		Reporter.log("save button is clicked", true);
		
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, -250)");
		
		driver.findElement(By.xpath("//span[text()='Employee List']")).click();
		Reporter.log("Emloyee list is seleced",true);
		
		String employee_name= firstname + " ".concat(middlename) + " ".concat(lastname); 
		Reporter.log( employee_name+ " is selected as employee full name", true);
		
		driver.findElement(By.xpath("//input[@placeholder='Employee Name']")).sendKeys(employee_name);
		Reporter.log("Employee name entered in search tab",true);
		
		driver.findElement(By.xpath("//input[@placeholder='Employee Name']")).sendKeys(Keys.ARROW_DOWN);
		Reporter.log("Employee selected from the dropdown",true);

		driver.findElement(By.xpath("//input[@placeholder='Employee Name']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		String element_employee=driver.findElement(By.xpath("//table[@id='employeeListTable']//td[3]")).getText();
		Reporter.log(element_employee, true);
		
		assertion.assertEquals(element_employee, employee_name, "Employee details do not exist");
		Reporter.log("Employee details exist",true);
		
		WebElement dropdown_logout = driver.findElement(By.xpath("//i[text()='keyboard_arrow_down']"));
		js.executeScript("arguments[0].click();",dropdown_logout);
		Reporter.log("Logout dropdown is clicked",true);
		
		WebElement element_logoutBtn=driver.findElement(By.xpath("//ul[@id='user_menu']//li[3]/a"));
		js.executeScript("arguments[0].click();", element_logoutBtn);
		Reporter.log("Successfully logged out of the browser", true); 
		
		Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("Browser is closed", true);
		assertion.assertAll();
	}
}


