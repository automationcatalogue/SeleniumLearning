package tesngScripts;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EvenSumOddSum {
	@Test (groups = {"SmokeTest"})
	public void evenOdd() {
		int i=3, evensum=0, oddsum=0;
		do{
			
			if(i%2==0){
				evensum=evensum+i;
			}else{
				oddsum=oddsum+i;
			}
			i++;
		}while(i<=14);
		System.out.println("Evensum value is :"+evensum+" Oddsum value is :"+oddsum);
	}
	
	@Test(groups = {"SmokeTest","SanityTest"})
	public void positiveOrNegative() {
		int i=-10;
		if(i>0) {
			Reporter.log("Positive Number...!!!", true);
		}else if(i<0) {
			Reporter.log("Negative Number...!!!", true);
		}else {
			Reporter.log("Zero Neither Positive nor Negative", true);
		}
		
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("Before Test Annotation in EvenSumOddSum", true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("After Test Annotation in EvenSumOddSum", true);
	}
}
