package tesngScripts;

import org.testng.annotations.Test;

public class PatternDemo {
	@Test(groups = {"FunctionalTest","SanityTest","SmokeTest"})
	public void pattern1() {

		for(int i=1;i<=5;i++){
			
			for(int j=1;j<=i;j++){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	@Test(groups = {"RegressionTest","FunctionalTest"})
	public void pattern2() {

		for(int i=1;i<=5;i++){
			
			for(int j=1;j<=i;j++){
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
