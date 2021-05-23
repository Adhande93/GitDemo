package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener{

	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.configReport();
	ThreadLocal<ExtentTest> threadTest= new ThreadLocal<ExtentTest>();		//It Provides Thread safe to Tests and avoid conflicts in test
																			//Helpful for Parallel Execution
	public void onTestStart(ITestResult result) {

		test= extent.createTest(result.getMethod().getMethodName());
		threadTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {

		threadTest.get().log(Status.PASS, "Test Passed");		//This will display Method name which are successfully executed


	}

	public void onTestFailure(ITestResult result) {

		threadTest.get().fail(result.getThrowable());   				//This will capture the Failure and Log it in ExtentReport
		WebDriver driver=null;

		String testCaseName=result.getMethod().getMethodName();		//This gives the Name of the Method which Fails 
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {

		}

		try {
			threadTest.get().addScreenCaptureFromPath(getScreenShotPath(testCaseName, driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestResult result) {

		extent.flush();

	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}



}
