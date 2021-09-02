package tesngScripts;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo2 {
	@Test(priority = 2)
	public void evenOdd() {
		int x=99;
		if(x%2==0) {
			Reporter.log("Given number is Even...!!!", true);
		}else {
			Reporter.log("Given number is Odd", true);
		}
	}
	
	@Test (priority = 3)
	public void cube() {
		int x=5;
		int y =x * x * x;
		Reporter.log("Cube of the given number is: "+y, true);
	}
	
	@Test(priority = 1)
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
	
	@BeforeMethod
	public void beforeM() {
		Reporter.log("I am in the Before Method", true);
		Reporter.log("Hello India, I am learning TestNG...!!!", true);
	}
	
	@AfterMethod
	public void afterM() {
		Reporter.log("I am in the After Method");
		Reporter.log("Hello, this is the end...!!!");
	}
	
	@BeforeClass
	public void beforeC() {
		int a=10, b=20;
		int c=a+b;
		Reporter.log("Addition of a, b is :"+c);
	}
	
	@AfterClass
	public void afterC() {
		int x=30, y=99;
		int z=y-x;
		Reporter.log("Value of z is :"+z);
	}
	
}






















