package tesngScripts;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FibonacciDemo {
	@Test(groups = {"FunctionalTest","Broken"})
	public void test1() {
		int a=8;
		if(a%2==0) {
			Reporter.log("Even number..!!!", true);
		}else {
			Reporter.log("Odd number...!!!", true);
		}
	}
	
	@Test(groups = {"SmokeTest","RegressionTest","FunctionalTest","Broken"})
	public void fibonacci() {
		int a=0, b=1;
		int c=a+b;
		System.out.print(a+"\t"+b+"\t");
		for(int i=1;i<=10;i++) {
			a=b;
			b=c;
			c=a+b;
			System.out.print(c+"\t");
		}
	}
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Before Suite execution ....!!!!", true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("After Suite execution ....!!!!", true);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("Before Method Execution...!!!", true);
	}
	
	@AfterMethod
	public void afterMethod() {
		Reporter.log("After Method Execution...!!!", true);
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("Before Class Execution...!!!", true);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("After Class Execution...!!!", true);
	}
}
