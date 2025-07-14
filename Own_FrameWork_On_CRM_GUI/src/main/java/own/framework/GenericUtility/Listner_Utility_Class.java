package own.framework.GenericUtility;

import java.time.LocalDate;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		LocalDate date = LocalDate.now();
		spark = new ExtentSparkReporter("./AdvanceReport/ExtentReport_" + date + ".html");
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
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getMethod().getMethodName());
		Utility_Class_Object_Own.settest(test);
		Utility_Class_Object_Own.gettest().log(Status.INFO, result.getMethod().getMethodName()+"Execution Start");		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot takescreen = (TakesScreenshot) Utility_Class_Object_Own.getdriver();
		String filePath = takescreen.getScreenshotAs(OutputType.BASE64);
		LocalDate time = LocalDate.now();
		Utility_Class_Object_Own.gettest().addScreenCaptureFromBase64String(filePath, testName + "_" + time);
		Utility_Class_Object_Own.gettest().log(Status.PASS,result.getMethod().getMethodName() + "Succesfully Executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot takescreen = (TakesScreenshot) Utility_Class_Object_Own.getdriver();
		String filePath = takescreen.getScreenshotAs(OutputType.BASE64);
		LocalDate time = LocalDate.now();
		Utility_Class_Object_Own.gettest().addScreenCaptureFromBase64String(filePath, testName + "_" + time);
		Utility_Class_Object_Own.gettest().log(Status.FAIL, result.getMethod().getMethodName() + "==> TEST Failed");
		Utility_Class_Object_Own.gettest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot takescreen = (TakesScreenshot) Utility_Class_Object_Own.getdriver();
		String filePath = takescreen.getScreenshotAs(OutputType.BASE64);
		LocalDate time = LocalDate.now();
		Utility_Class_Object_Own.gettest().addScreenCaptureFromBase64String(filePath, testName + "_" + time);
		Utility_Class_Object_Own.gettest().log(Status.SKIP, result.getMethod().getMethodName() + "==> TEST Skipped");
		Utility_Class_Object_Own.gettest().log(Status.FAIL, result.getThrowable());

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
