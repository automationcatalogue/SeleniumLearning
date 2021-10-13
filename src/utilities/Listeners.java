package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import pageMethods.BaseClass;

public class Listeners implements ITestListener {
	private static String projectPath = System.getProperty("user.dir");
	private static String timestamp;

	@Override
	public void onTestStart(ITestResult result) {
		String className=Thread.currentThread().getStackTrace()[1].getClassName().substring(Thread.currentThread().getStackTrace()[1].getClassName().indexOf('.')+1);
		System.out.println(className);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("onTestSuccess Method is executed: " + result.getName(), true);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(projectPath + "\\Screenshots\\"+timestamp+"\\"+Utility.getClassName()+"_Failure.jpg");
			Log.info("Failure Screenshotname is :"+projectPath + "\\Screenshots\\"+timestamp+"\\"+Utility.getClassName()+"_Failure.jpg");
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			Reporter.log("Exception Occurred while taking the screenshot " + e.getMessage(), true);
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("onTestSkipped Method is executed: " + result.getName(), true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("onTestFailedButWithinSuccessPercentage Method is executed: " + result.getName(), true);

	}

	@Override
	public void onStart(ITestContext context) {
		// Creating the Directory/folder based on timestamp

		PropertyConfigurator.configure(projectPath + "\\resources\\Log4j.properties");

		DateFormat df = new SimpleDateFormat("yyyy-MMM-dd hh-mm-ss");
		Date date = new Date();
		timestamp = df.format(date);
		Log.info("Generated TimeStamp is :" + timestamp);
		System.out.println("Generated TimeStamp is :" + timestamp);

		File file = new File(projectPath + "\\Screenshots\\" + timestamp);
		file.mkdir();

	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("onFinish Method is executed: " + context.getName(), true);
	}

}
