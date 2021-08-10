package excelUtils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class PropExcelDemo {
public static void main(String[] args) throws Exception{
		
		FileInputStream fis_prop = new FileInputStream("C:\\Eclipse\\SeleniumLectures\\SeleniumLearning\\TestData\\Config.properties");
		Properties prop = new Properties();
		prop.load(fis_prop);
		
		String browser_value=prop.getProperty("browser");
		System.out.println("Browser value is :"+browser_value);
		
		String testDataPath=prop.getProperty("testdatapath");
		System.out.println("TestData Path is :"+testDataPath);
		
		String driverPath=prop.getProperty("driverpath");
		System.out.println("Driver Path is :"+driverPath);
		
		String rowNumber=prop.getProperty("rownNmber");
		System.out.println("rowNumber Data is :"+rowNumber);
		int iRow=Integer.parseInt(rowNumber);
		
		
		String username_colNumber=prop.getProperty("username_colNumber");
		String password_colNumber=prop.getProperty("password_colNumber");
		String status_colNumber=prop.getProperty("status_colNumber");
		
		
		FileOutputStream fos_prop = new FileOutputStream("C:\\Eclipse\\SeleniumLectures\\SeleniumLearning\\TestData\\Config.properties");
		prop.setProperty("browser", "opera");
		prop.store(fos_prop,"Data is updated successfully");
		fis_prop.close();
		fos_prop.close();
		
		FileInputStream fis = new FileInputStream(testDataPath);
		
		XSSFWorkbook wbk = new XSSFWorkbook(fis);
		XSSFSheet sheet=wbk.getSheet("OrangeHRM");
		
		String username =sheet.getRow(Integer.parseInt(rowNumber)).getCell(Integer.parseInt(username_colNumber)).getStringCellValue();
		String password =sheet.getRow(Integer.parseInt(rowNumber)).getCell(Integer.parseInt(password_colNumber)).getStringCellValue();
		
		
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testsautomation-trials71.orangehrmlive.com");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		System.out.println(username+" is entered in the OrangeHRM website");
		
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		System.out.println(password+" is entered in the OrangeHRM website");
		
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		System.out.println("Click action is performed on Login button");
		
		XSSFRow row=sheet.getRow(iRow);
		XSSFCell cell=row.getCell(Integer.parseInt(status_colNumber));
		
		try{
			boolean pageLoad=driver.findElement(By.xpath("//li[@class='page-title' and text()='Dashboard']")).isDisplayed();
			System.out.println("Login is successful and Home page is loaded...");
			
			
			
			if(cell==null){
				cell=row.createCell(Integer.parseInt(status_colNumber));
				cell.setCellValue("PASS");
				System.out.println("Cell is created and PASS status is written");
			}else{
				cell.setCellValue("PASS");
				System.out.println("Cell is alreay available and PASS status is written");
			}
			
		}catch(Exception e){
			System.out.println("Login is failed and Exception Occured in the program...!!!");
			

			if(cell==null){
				cell=row.createCell(Integer.parseInt(status_colNumber));
				cell.setCellValue("FAIL");
				System.out.println("Cell is created and FAIL status is written");
			}else{
				cell.setCellValue("FAIL");
				System.out.println("Cell is alreay available and FAIL status is written");
			}
			
		}
		
		System.out.println("Row Data is below: ");
		int col_value=row.getLastCellNum();
		System.out.println("Column Number count is :"+col_value);
		for(int i=0;i<col_value;i++){
			String data=sheet.getRow(iRow).getCell(i).getStringCellValue();
			System.out.println(data);
			
		}
		
		System.out.println("Column Data is below");
		int row_num=sheet.getLastRowNum();
		System.out.println("Row Number count is :"+row_num);
		for(int i=0;i<=row_num;i++){
			String pwdData=sheet.getRow(i).getCell(Integer.parseInt(password_colNumber)).getStringCellValue();
			System.out.println(pwdData);
		}
		
		
		
		System.out.println("Entire Sheet Data is ");
		for(int i=0;i<=row_num;i++){
			int cell_num=sheet.getRow(i).getLastCellNum();
			for(int j=0;j<cell_num;j++){
				
				String data=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		
		
		FileOutputStream fos = new FileOutputStream(testDataPath);
		wbk.write(fos);
		fis.close();
		fos.close();
	}
}
