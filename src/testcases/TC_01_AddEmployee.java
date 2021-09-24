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


public class TC_01_AddEmployee {
	
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
		Reporter.log("Browser Name from the TestNG.xml is :"+browser);
		driver=Utility.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void add_Employee() throws Exception {
		
		
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
		
		String firstname =ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_firsname, "OrangeHRM");
		String middlename=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_middlename, "OrangeHRM");
		String lastname=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_lastname, "OrangeHRM");
		
		driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
		Reporter.log("Add Employee modal exists ", true);

		driver.findElement(By.xpath("//div[@class='input-group']/input[1]")).sendKeys(firstname);
		Reporter.log(firstname+" is enered as first name in the text-box", true);
		
		driver.findElement(By.xpath("//div[@class='input-group']/input[2]")).sendKeys(middlename);
		Reporter.log(middlename+ " is enered as middle name in the text-box", true);
		
		driver.findElement(By.xpath("//div[@class='input-group']/input[3]")).sendKeys(lastname);
		Reporter.log(lastname+ "is enered as  nalastme in the text-box", true);
		
		//String emp_id=driver.findElement(By.xpath("//input[@id='employeeId']")).getText();
		//System.out.println(emp_id);
		
		driver.findElement(By.xpath("//i[text()='arrow_drop_down']")).click();
		Reporter.log("Location dropdown button is clicked", true);
		
		int location_size=driver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']/li/a/span")).size();
		Reporter.log("Number of locations available:" + location_size, true);
		
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
		
		WebElement element_EmployeeDetailsTab=driver.findElement(By.id("employement_details_tab"));
		wait.until(ExpectedConditions.visibilityOf(element_EmployeeDetailsTab));
		Reporter.log("Employee details page is displayed",true);
		
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.height)");
		Thread.sleep(1000);
		//Utility.retryClick(driver, By.xpath("//label[contains(text(),'Region')]/..//following-sibling::input[1]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[contains(text(),'Region')]/..//following-sibling::input[1]")));
		Reporter.log("Region drop-down is clicked", true);
		
		String Region=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Region, "OrangeHRM");

		Utility.selection_dropdown(driver,"//div[@id='9_inputfileddiv']/div/ul/li/span",Region);
		Reporter.log(Region+ " is selcted from the dropdown", true);
		
		WebElement element_FTE_dd=driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_FTE_dd);
		Reporter.log("FTE drop-down is clicked",true);
		
		String FTE=ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_FTE, "OrangeHRM");

		Utility.selection_dropdown(driver,"//div[@id='10_inputfileddiv']/div/ul/li/span",FTE);
		Reporter.log(FTE+ " is selected from the dropdown",true);
		
		WebElement element_tempdept_dd=driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_tempdept_dd);
		Reporter.log("Temporary department drop-down is clicked",true);
		
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
		
		driver.findElement(By.xpath("//td[text()='0157']")).getText();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("Browser is closed", true);
		assertion.assertAll();
	}
}


