package tesngScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	@DataProvider(name="DPDemo")
	public Object[][] getData(){
		
		Object[][] ob1 = new Object[4][2];
		ob1[0][0]="Admin";
		ob1[0][1]="Admin@123";
		
		ob1[1][0]="Sagar";
		ob1[1][1]="Test@1234";
		
		ob1[2][0]="Vijetha";
		ob1[2][1]="Demo@123";
		
		ob1[3][0]="Ravi";
		ob1[3][1]="Test123";
				
		
		return ob1;
		
	}
	
	@Test(dataProvider = "DPDemo")
	public void print(String username, String password) {
		System.out.println("Username is "+username+" password is "+password);
	}

}
