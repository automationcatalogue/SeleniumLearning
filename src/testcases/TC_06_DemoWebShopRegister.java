package testcases;

public class TC_06_DemoWebShopRegister {
	public static void main(String[] args) throws Exception {
		Register.openBrowser();
		Register.register();
		Login.login();
	}

}
