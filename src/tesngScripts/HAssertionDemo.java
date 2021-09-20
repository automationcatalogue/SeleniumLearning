package tesngScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HAssertionDemo {
	@Test
	public void verifyData(){
		String data="Sagar123";
		
		//if (data.equalsIgnoreCase("Sagar")) {
			//Reporter.log("Data is matched", true);
		//}else {
			//Reporter.log("Data is not matched", true);
		//}
		
		SoftAssert ob = new SoftAssert();
		
		ob.assertEquals(data, "Sagar123", "Data is not matched");
		
		ob.assertNotEquals(data, "Sagar123");
		
		int a=10, b=20;
		int c=a+b;
		Reporter.log("Addition of a, b is :"+c, true);
		
		ob.assertAll();
	}
	
	@Test
	public void verifyData_1() {
		int a=10;
		Assert.assertTrue(a>=100);
	}
}





















