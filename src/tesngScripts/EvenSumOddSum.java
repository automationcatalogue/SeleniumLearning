package tesngScripts;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EvenSumOddSum {
	@Test
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
	@BeforeTest
	public void beforeTest() {
		Reporter.log("Before Test Annotation in EvenSumOddSum", true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("After Test Annotation in EvenSumOddSum", true);
	}
}
