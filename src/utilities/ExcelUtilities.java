package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	private static XSSFWorkbook excelWBook;
	private static XSSFSheet excelSheet;
	private static XSSFRow excelRow;
	private static XSSFCell excelCell;
	
	/**
	 * This method is used to Set the Path of a Excel file
	 */
	
	public static void setExcelFile(String sPath) throws Exception{
		try {
			FileInputStream fis = new FileInputStream(sPath);
			excelWBook = new XSSFWorkbook(fis);
		}catch(FileNotFoundException fe) {
			System.err.print("File is not found....!!!"+fe);
			throw (fe);
		}
	}
	
	/**
	 * This method is used to Read the Data from Excel
	 */
	public static String getCellData(int iRowNumber, int iColumnNumber, String sSheetName) throws Exception{
		
		excelSheet = excelWBook.getSheet(sSheetName);
		try {
			String sCellData=excelSheet.getRow(iRowNumber).getCell(iColumnNumber).getStringCellValue();
			return sCellData;
		}catch(Exception e) {
			System.out.println("Error in while reading the excel data...!!!");
			throw (e);
		}
		
		
	}
	
	/**
	 * This method is used to write the data to excel 
	 */
	public static void setCellData(String sData, int iRowNumber, int iColumnNumber, String sFileName, String excelPath) throws Exception{
		excelSheet = excelWBook.getSheet(sFileName);
		try {
			 excelRow = excelSheet.getRow(iRowNumber);
			 excelCell = excelRow.getCell(iColumnNumber);
			 
			 if(excelCell ==null) {
				 excelCell=excelRow.createCell(iColumnNumber);
				 excelCell.setCellValue(sData);
			 }else {
				 excelCell.setCellValue(sData);
			 }
			 
			 FileOutputStream fos = new FileOutputStream(excelPath);
			 excelWBook.write(fos);
			 fos.close();
			 
		}catch(Exception e) {
			System.out.println("Error in While writing the excel Data...!!!");
			throw (e);
		}
	}
}
