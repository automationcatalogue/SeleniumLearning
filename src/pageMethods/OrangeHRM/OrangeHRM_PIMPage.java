package pageMethods.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import pageMethods.BaseClass;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.RandomGenerator;
import utilities.Utility;

public class OrangeHRM_PIMPage {
	static WebDriver driver=BaseClass.getDriver();
	static String firstname, middlename, lastname;

	public static void allAddEmployeeActions(String excelPath) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// firstname
		firstname = RandomGenerator.randomAlphabet(5, 8);
		driver.findElement(By.xpath("//div[@class='input-group']/input[1]")).sendKeys(firstname);
		ExcelUtilities.setCellData(firstname, Constant.RowNumber_five, Constant.col_Firstname, "OrangeHRM", excelPath);
		Log.info(firstname + "First-name entered in the text-box");

		// middlename
		middlename = RandomGenerator.randomAlphabet(3, 4);
		driver.findElement(By.xpath("//div[@class='input-group']/input[2]")).sendKeys(middlename);
		ExcelUtilities.setCellData(firstname, Constant.RowNumber_five, Constant.col_middlename, "OrangeHRM", excelPath);
		Log.info(middlename + " is enered as middle name in the text-box");

		// lastname
		lastname = RandomGenerator.randomAlphabet(3, 6);
		driver.findElement(By.xpath("//div[@class='input-group']/input[3]")).sendKeys(lastname);
		ExcelUtilities.setCellData(firstname, Constant.RowNumber_five, Constant.col_lastname, "OrangeHRM", excelPath);
		Log.info(lastname + "is enered as  nalastme in the text-box");

		driver.findElement(By.xpath("//i[text()='arrow_drop_down']")).click();
		Log.info("Location dropdown button is clicked");

		// locations
		int location_size = driver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']/li/a/span")).size();
		Log.info("Number of locations available:" + location_size);

		String datalocation = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_datalocation, "OrangeHRM");
		Utility.selection_dropdown(driver, "//ul[@class='dropdown-menu inner show']/li/a/span", datalocation);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-secondary']")));
		Thread.sleep(1000);
		WebElement btn_Next = driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_Next);
		Log.info("Next button is clicked");

		driver.findElement(By.xpath("//div[@id='personal_details_tab']")).isDisplayed();
		Log.info("Personal details page is displayed");

		driver.findElement(By.xpath("//input[@id='otherId']")).sendKeys("JJ123");
		Log.info("Entered data in other Id field");

		WebElement element_nationality_dd = driver
				.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']/div/input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_nationality_dd);
		Log.info("Nationality drop-down is clicked");

		String nationality = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Nationality, "OrangeHRM");
		Utility.selection_dropdown(driver, "//div[@id='nation_code_inputfileddiv']/div/ul/li/span", nationality);
		Log.info(nationality + " is selected as nationality of the employee");

		int elements_marital_status = driver
				.findElements(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//following-sibling::ul/li/span"))
				.size();
		Log.info("Option under marital status are " + elements_marital_status);

		WebElement element_maritalstatus_dd1 = driver
				.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']/div/input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_maritalstatus_dd1);
		Log.info("marital status drop-down is clicked");

		String maritalstatus = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_maritalstatus, "OrangeHRM");
		Utility.selection_dropdown(driver,
				"//div[@id='emp_marital_status_inputfileddiv']//following-sibling::ul/li/span", maritalstatus);

		WebElement element_gender_dd = driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']/div/input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_gender_dd);
		Log.info("Gender drop-down is clicked");

		String gender = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Gender, "OrangeHRM");

		Utility.selection_dropdown(driver, "//div[@id='emp_gender_inputfileddiv']/div/ul/li/span", gender);
		Log.info("Gender is selcted as :" + gender);

		driver.findElement(By.xpath("//label[text()='Hobbies']//preceding-sibling::input")).sendKeys("Reading novels");
		Log.info("Data entered in hobbies field");

		driver.findElement(By.xpath("//button[text()='Next']")).click();
		Log.info("Next button is clicked");

		Utility.waitForPageLoad(driver);
		Log.info("Employee details page is displayed");

		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Save']")));
		Thread.sleep(1000);
		Utility.retryClick(driver, By.xpath("//label[contains(text(),'Region')]/..//following-sibling::input[1]"));
		Log.info("Region drop-down is clicked");
		Thread.sleep(1000);
		String Region = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Region, "OrangeHRM");
		Utility.selection_dropdown(driver, "//div[@id='9_inputfileddiv']/div/ul/li/span", Region);
		Log.info(Region + " is selcted from the dropdown");
		Thread.sleep(1000);

		js.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//label[contains(text(),'FTE')]/..//following-sibling::input[1]")));
		Log.info("FTE drop-down is clicked");

		String FTE = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_FTE, "OrangeHRM");
		Utility.selection_dropdown(driver, "//div[@id='10_inputfileddiv']/div/ul/li/span", FTE);
		Log.info(FTE + " is selected from the dropdown");
		Thread.sleep(1000);

		js.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//label[contains(text(),'Temporary')]/..//following-sibling::input[1]")));
		Log.info("Temporary department drop-down is clicked");
		Thread.sleep(1000);
		String TempDep = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_TempDepartment, "OrangeHRM");
		Utility.selection_dropdown(driver, "//div[@id='11_inputfileddiv']/div/ul/li/span", TempDep);
		Log.info(TempDep + " is selected  from the dropdown");

		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Log.info("Save button is clicked");

		Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='pim-container'])[2]")).isDisplayed(),
				"Personal Details page is not displayed");

		WebElement save_btn = driver.findElement(By.xpath("(//button[text()='save'])[1]"));

		Actions action = new Actions(driver);
		action.click(save_btn).build().perform();
		Log.info("save buttonn is clicked");

		driver.findElement(By.xpath("(//li[@ng-repeat='item in form.titleMap'])[1]")).click();
		Log.info("Food selection radio button is clicked");

		WebElement save_btn1 = driver.findElement(By.xpath("(//button[text()='save'])[2]"));

		Actions action1 = new Actions(driver);
		action1.click(save_btn1).build().perform();
		Log.info("save button is clicked");

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -250)");

		driver.findElement(By.xpath("//span[text()='Employee List']")).click();
		Log.info("Emloyee list is seleced");
	}
	
	public static void verifyEmployeeDetails() throws Exception{
		String employee_name= firstname + " ".concat(middlename) + " ".concat(lastname); 
		Log.info( employee_name+ " is selected as employee full name");
		
		driver.findElement(By.xpath("//input[@placeholder='Employee Name']")).sendKeys(employee_name);
		Log.info("Employee name entered in search tab");
		
		driver.findElement(By.xpath("//input[@placeholder='Employee Name']")).sendKeys(Keys.ARROW_DOWN);
		Log.info("Employee selected from the dropdown");

		driver.findElement(By.xpath("//input[@placeholder='Employee Name']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		String element_employee=driver.findElement(By.xpath("//table[@id='employeeListTable']//td[3]")).getText();
		Log.info(element_employee);
		
		Assert.assertEquals(element_employee, employee_name, "Employee details do not exist");
		Log.info("Employee details exist");
	}
}
