package own.framework.GenericUtility;

import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import static own.framework.GenericUtility.Utility_Class_Object_Own.*;

public class Listner_Utility_Class implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time = new Date().toString().replace(" ", "_").replace(": ", "_").replace(" -", "_");
		spark = new ExtentSparkReporter("./AdvanceReport/ExtentReport_" + time + ".html");
		spark.config().setDocumentTitle("Own CRM Project Test Suite Result");
		spark.config().setReportName("Own CRM Report");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "wINDOWS-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===========" + result.getMethod().getMethodName() + ">>>START===========");
		test = report.createTest(result.getMethod().getMethodName());
		Utility_Class_Object_Own.settest(test);
		Utility_Class_Object_Own.gettest().log(Status.INFO, result.getMethod().getMethodName() + "=====>STARTED=====");
		// test.log(Status.INFO,
		// result.getMethod().getMethodName()+"=====>>>>STARTED<<<<=====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Utility_Class_Object_Own.gettest().log(Status.PASS, result.getMethod().getMethodName() + "=====>>>>PASS<<<<=====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		String testName = result.getMethod().getMethodName();
////		TakesScreenshot ts = (TakesScreenshot) ;
////		String filePath = ts.getScreenshotAs(OutputType.BASE64);
//		String time = new Date().toString().replace("-", "_").replace(":", "_").replace(" ", "_");
//		test.addScreenCaptureFromBase64String(filePath, testName + "_" + time);
//		test.log(Status.INFO, result.getMethod().getMethodName() + "==> TEST FAILED <==");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}
}
