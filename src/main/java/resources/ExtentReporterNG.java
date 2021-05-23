package resources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReporterNG {
	static ExtentReports extent;
	
	//we can declare this Method as static so that we can call it directly in Listeners without creating the object of this class
	
	@BeforeTest
	public static ExtentReports configReport() {
		
		//to generate ExtentReport we need 2 classes i.e ExtentReport and ExtentSparkReporter
										//("user.dir")+
		String path=System.getProperty(("user.dir")+"\\reports\\index.html");
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test result");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Akash");
		return extent;
	
	}

}
