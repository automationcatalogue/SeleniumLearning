package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TC_06_DemoWebShopRegister {
	@Test
	public void login_DemoWebshop() throws Exception {
		Register.openBrowser();
		Register.register();
		Login.login();
	}
	@AfterClass
	public void afterClass() {
		Register.driver.quit();
	}

}
