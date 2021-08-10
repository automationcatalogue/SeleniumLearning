package testcases;

public class Register_Login {
	public static void main(String[] args) throws Exception {
		Register.openBrowser();
		Register.register();
		Login.login();
	}

}
