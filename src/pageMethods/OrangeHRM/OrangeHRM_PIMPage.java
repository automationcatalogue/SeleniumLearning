package pageMethods.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageMethods.BaseClass;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;
import utilities.RandomGenerator;
import utilities.Utility;

public class OrangeHRM_PIMPage {
	static String firstname, middlename, lastname;
	
	public static final String txtbox_firstname="//div[@class='input-group']/input[1]";
	public static final String txtbox_middlename="//div[@class='input-group']/input[2]";
	public static final String txtbox_lastname="//div[@class='input-group']/input[3]";
	public static final String dd_location="//i[text()='arrow_drop_down']";
	public static final String count_location="//ul[@class='dropdown-menu inner show']/li/a/span";
	public static final String dd_datalocation="//ul[@class='dropdown-menu inner show']/li/a/span";
	public static final String btn_next="//button[@class='btn btn-secondary']";
	public static final String page_personalDetails="//div[@id='personal_details_tab']";
	public static final String txtbox_otherID="//input[@id='otherId']";
	public static final String dd_nationalityselection="//div[@id='nation_code_inputfileddiv']/div/input";
	public static final String dd_nationality="//div[@id='nation_code_inputfileddiv']/div/ul/li/span";
	public static final String options_maritalstatus="//div[@id='emp_marital_status_inputfileddiv']//following-sibling::ul/li/span";
	public static final String dd_maritalstatus_selection="//div[@id='emp_marital_status_inputfileddiv']/div/input";
	public static final String dd_maritalstatus="//div[@id='emp_marital_status_inputfileddiv']//following-sibling::ul/li/span";
	public static final String dd_gender_selection="//div[@id='emp_gender_inputfileddiv']/div/input";
	public static final String dd_gender ="//div[@id='emp_gender_inputfileddiv']/div/ul/li/span";
	public static final String txtbox_hobbies="//label[text()='Hobbies']//preceding-sibling::input";
	public static final String btn_next1="//button[text()='Next']";
	public static final String btn_save="//button[text()='Save']";
	public static final String dd_region_selection="//label[contains(text(),'Region')]/..//following-sibling::input[1]";
	public static final String dd_region = "//div[@id='9_inputfileddiv']/div/ul/li/span";
	public static final String dd_FTE_selection="//label[contains(text(),'FTE')]/..//following-sibling::input[1]";
	public static final String dd_FTE="//div[@id='10_inputfileddiv']/div/ul/li/span";
	public static final String dd_temprorarydept_selection ="//label[contains(text(),'Temporary')]/..//following-sibling::input[1]";
	public static final String dd_temprorarydept="//div[@id='11_inputfileddiv']/div/ul/li/span";
	public static final String page_personaldetails="(//div[@class='pim-container'])[2]";
	public static final String btn_Save="(//button[text()='save'])[1]";
	public static final String rbtn_foodselection="(//li[@ng-repeat='item in form.titleMap'])[1]";
	public static final String btn_save1 ="(//button[text()='save'])[2]";
	public static final String link_employeeList="//span[text()='Employee List']";
	

	public static void allAddEmployeeActions(String excelPath) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor)BaseClass.getDriver();
		
		// firstname
		firstname = RandomGenerator.randomAlphabet(5, 8);
		BaseClass.getDriver().findElement(By.xpath(txtbox_firstname)).sendKeys(firstname);
		ExcelUtilities.setCellData(firstname, Constant.RowNumber_five, Constant.col_Firstname, "OrangeHRM", excelPath);
		Log.info(firstname + "First-name entered in the text-box");

		// middlename
		middlename = RandomGenerator.randomAlphabet(3, 4);
		BaseClass.getDriver().findElement(By.xpath(txtbox_middlename)).sendKeys(middlename);
		ExcelUtilities.setCellData(firstname, Constant.RowNumber_five, Constant.col_middlename, "OrangeHRM", excelPath);
		Log.info(middlename + " is enered as middle name in the text-box");

		// lastname
		lastname = RandomGenerator.randomAlphabet(3, 6);
		BaseClass.getDriver().findElement(By.xpath(txtbox_lastname)).sendKeys(lastname);
		ExcelUtilities.setCellData(firstname, Constant.RowNumber_five, Constant.col_lastname, "OrangeHRM", excelPath);
		Log.info(lastname + "is enered as  nalastme in the text-box");

		BaseClass.getDriver().findElement(By.xpath(dd_location)).click();
		Log.info("Location dropdown button is clicked");

		// locations
		int location_size = BaseClass.getDriver().findElements(By.xpath(count_location)).size();
		Log.info("Number of locations available:" + location_size);

		String datalocation = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_datalocation, "OrangeHRM");
		Utility.selection_dropdown(BaseClass.getDriver(), dd_datalocation, datalocation);

		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btn_next)));
		Thread.sleep(1000);
		WebElement btn_Next = BaseClass.getDriver().findElement(By.xpath(btn_next));
		((JavascriptExecutor) BaseClass.getDriver()).executeScript("arguments[0].click();", btn_Next);
		Log.info("Next button is clicked");

		BaseClass.getDriver().findElement(By.xpath(page_personalDetails)).isDisplayed();
		Log.info("Personal details page is displayed");

		BaseClass.getDriver().findElement(By.xpath(txtbox_otherID)).sendKeys("JJ123");
		Log.info("Entered data in other Id field");

		WebElement element_nationality_dd = BaseClass.getDriver()
				.findElement(By.xpath(dd_nationalityselection));
		((JavascriptExecutor) BaseClass.getDriver()).executeScript("arguments[0].click();", element_nationality_dd);
		Log.info("Nationality drop-down is clicked");

		String nationality = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Nationality, "OrangeHRM");
		Utility.selection_dropdown(BaseClass.getDriver(),dd_nationality , nationality);
		Log.info(nationality + " is selected as nationality of the employee");

		int elements_marital_status = BaseClass.getDriver()
				.findElements(By.xpath(options_maritalstatus))
				.size();
		Log.info("Option under marital status are " + elements_marital_status);

		WebElement element_maritalstatus_dd1 = BaseClass.getDriver()
				.findElement(By.xpath(dd_maritalstatus_selection));
		((JavascriptExecutor) BaseClass.getDriver()).executeScript("arguments[0].click();", element_maritalstatus_dd1);
		Log.info("marital status drop-down is clicked");

		String maritalstatus = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_maritalstatus, "OrangeHRM");
		Utility.selection_dropdown(BaseClass.getDriver(),dd_maritalstatus, maritalstatus);

		WebElement element_gender_dd = BaseClass.getDriver().findElement(By.xpath(dd_gender_selection));
		((JavascriptExecutor) BaseClass.getDriver()).executeScript("arguments[0].click();", element_gender_dd);
		Log.info("Gender drop-down is clicked");

		String gender = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Gender, "OrangeHRM");

		Utility.selection_dropdown(BaseClass.getDriver(), dd_gender, gender);
		Log.info("Gender is selcted as :" + gender);

		BaseClass.getDriver().findElement(By.xpath(txtbox_hobbies)).sendKeys("Reading novels");
		Log.info("Data entered in hobbies text box");

		BaseClass.getDriver().findElement(By.xpath(btn_next1)).click();
		Log.info("Next button is clicked");

		Utility.waitForPageLoad(BaseClass.getDriver());
		Log.info("Employee details page is displayed");

		js.executeScript("arguments[0].scrollIntoView(true);", BaseClass.getDriver().findElement(By.xpath(btn_save)));
		Thread.sleep(1000);
		Utility.retryClick(BaseClass.getDriver(), By.xpath(dd_region_selection));
		Log.info("Region drop-down is clicked");
		Thread.sleep(1000);
		String Region = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_Region, "OrangeHRM");
		Utility.selection_dropdown(BaseClass.getDriver(), dd_region, Region);
		Log.info(Region + " is selcted from the dropdown");
		Thread.sleep(1000);

		js.executeScript("arguments[0].click();",
				BaseClass.getDriver().findElement(By.xpath(dd_FTE_selection)));
		Log.info("FTE drop-down is clicked");

		String FTE = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_FTE, "OrangeHRM");
		Utility.selection_dropdown(BaseClass.getDriver(), dd_FTE, FTE);
		Log.info(FTE + " is selected from the dropdown");
		Thread.sleep(1000);

		js.executeScript("arguments[0].click();",
				BaseClass.getDriver().findElement(By.xpath(dd_temprorarydept_selection)));
		Log.info("Temporary department drop-down is clicked");
		Thread.sleep(1000);
		String TempDep = ExcelUtilities.getCellData(Constant.iRowNumber, Constant.col_TempDepartment, "OrangeHRM");
		Utility.selection_dropdown(BaseClass.getDriver(), dd_temprorarydept, TempDep);
		Log.info(TempDep + " is selected  from the dropdown");

		BaseClass.getDriver().findElement(By.xpath("//button[text()='Save']")).click();
		Log.info("Save button is clicked");

		Assert.assertTrue(BaseClass.getDriver().findElement(By.xpath(page_personaldetails)).isDisplayed(),
				"Personal Details page is not displayed");

		WebElement save_btn = BaseClass.getDriver().findElement(By.xpath(btn_Save));

		Actions action = new Actions(BaseClass.getDriver());
		action.click(save_btn).build().perform();
		Log.info("save buttonn is clicked");

		BaseClass.getDriver().findElement(By.xpath(rbtn_foodselection)).click();
		Log.info("Food selection radio button is clicked");

		WebElement save_btn1 = BaseClass.getDriver().findElement(By.xpath(btn_save1));

		Actions action1 = new Actions(BaseClass.getDriver());
		action1.click(save_btn1).build().perform();
		Log.info("save button is clicked");

		((JavascriptExecutor) BaseClass.getDriver()).executeScript("window.scrollTo(0, -250)");

		BaseClass.getDriver().findElement(By.xpath(link_employeeList)).click();
		Log.info("Emloyee list is seleced");
	}
	
	public static final String txtbox_employeeName="//input[@placeholder='Employee Name']";
	public static final String dd_employeeselection ="//input[@placeholder='Employee Name']";
	public static final String employeename_selection="//input[@placeholder='Employee Name']";
	public static final String display_employeename="//table[@id='employeeListTable']//td[3]";


	
	
	public static void verifyEmployeeDetails() throws Exception{
		String employee_name= firstname + " ".concat(middlename) + " ".concat(lastname); 
		Log.info( employee_name+ " is selected as employee full name");
		
		BaseClass.getDriver().findElement(By.xpath(txtbox_employeeName)).sendKeys(employee_name);
		Log.info("Employee name entered in search tab");
		
		BaseClass.getDriver().findElement(By.xpath(dd_employeeselection)).sendKeys(Keys.ARROW_DOWN);
		Log.info("Employee selected from the dropdown");

		BaseClass.getDriver().findElement(By.xpath(employeename_selection)).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		String element_employee=BaseClass.getDriver().findElement(By.xpath(display_employeename)).getText();
		Log.info(element_employee);
		
		Assert.assertEquals(element_employee, employee_name, "Employee details do not exist");
		Log.info("Employee details exist");
	}
}
