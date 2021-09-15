package tesngScripts;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrimeDemo {
	@BeforeTest
	public void beforeTest() {
		Reporter.log("Before Test Annotation of PrimeDemo...!!!", true);
		Reporter.log("Core Java...!!!", true);
		
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("After Test Annotation of PrimeDemo...!!!", true);
	}
	
	@Test(groups = {"RegressionTest","FunctionalTest"})
	public void primeDemo() {
		int x=17, count=0;
		for(int i=1;i<=x;i++) {
			if(x%i==0) {
				count++;
			}
		}
		if(count==2) {
			Reporter.log("Given number is Prime...!!!", true);
		}else {
			Reporter.log("Given number is not Prime...!!!", true);
		}
	}
	
}
