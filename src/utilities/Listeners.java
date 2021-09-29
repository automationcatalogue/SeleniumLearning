package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import pageMethods.BaseClass;

public class Listeners extends BaseClass implements ITestListener{
	
	public Listeners(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("onTestStart Method is executed: "+result.getName(), true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("onTestSuccess Method is executed: "+result.getName(), true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			String path=System.getProperty("user.dir");
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(path+"\\Screenshots\\Failure.jpg");
			FileUtils.copyFile(src, dest);
		}catch (Exception e) {
			Reporter.log("Exception Occurred while taking the screenshot "+e.getMessage(), true);
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("onTestSkipped Method is executed: "+result.getName(), true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("onTestFailedButWithinSuccessPercentage Method is executed: "+result.getName(), true);
		
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("onStart Method is executed: "+context.getName(), true);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("onFinish Method is executed: "+context.getName(), true);
	}

}
