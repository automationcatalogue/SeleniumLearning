package individualSeleniumScripts;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class RandomDemo {
	@Test
	public void randomData() {
		String data=RandomStringUtils.randomAlphabetic(8);
		System.out.println(data);
		
		String data1=RandomStringUtils.randomAlphabetic(4, 8);
		System.out.println(data1);
		
		String data2=RandomStringUtils.randomAlphanumeric(6);
		System.out.println(data2);
		
		Random r = new Random();
		int i=r.nextInt(5000);
		System.out.println(i);
		
		String s=RandomStringUtils.random(10,"ab$_.cd");
		System.out.println(s);
		
	}
}
