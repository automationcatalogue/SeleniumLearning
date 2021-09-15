package tesngScripts;


import org.testng.Reporter;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FactorialDemo {
	@BeforeTest
	public void beforeTest() {
		Reporter.log("Before Test Annotation in Factorial Demo", true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("After Test Annotation in Factorial Demo", true);
	}
	@Test(groups = {"RegressionTest"})
	public void factorial(){
		
		int fact=1, n;
		n=10;
		
		int temp=n;
		
		for(;n>=1;n--){
			fact=fact*n;
		}
		
		System.out.println("Factorial of a "+temp+" number is "+fact);
	}
	
	@Test(groups = {"RegressionTest","SanityTest"})
	public void cube() {
		int x=9;
		int y=x*x*x;
		Reporter.log("Cube of the Given number is :"+y, true);
	}
	
	@BeforeGroups
	public void beforeGroups() {
		Reporter.log("BeforeGroups Execution...!!!",true);
	}
	
	@AfterGroups
	public void afterGroups() {
		Reporter.log("AfterGroups Execution...!!!",true);
	}
}

























