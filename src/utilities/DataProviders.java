package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="LoginData")
	public static Object[][] getLoginData() throws Exception{
		
		Object[][] ob1 = new Object[4][2];
		
		for(int i=0;i<=3;i++) {
			
			for(int j=0;j<=1;j++) {
				ob1[i][j]=ExcelUtilities.getCellData(i+1, j+2, "OrangeHRMLogin");
			}
			
		}		
		return ob1;
		
	}
}
