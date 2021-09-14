package tesngScripts;

import org.testng.annotations.Test;

public class PatternDemo {
	@Test
	public void pattern() {

		for(int i=1;i<=5;i++){
			
			for(int j=1;j<=i;j++){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
