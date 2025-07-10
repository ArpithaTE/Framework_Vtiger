package own.framework.GenericUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class Utility_Class_Object_Own {
	public static ThreadLocal<ExtentTest> test= new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();

	public static ExtentTest gettest() {
		return test.get();
	}
	
	public static WebDriver getdriver() {
		return driver.get();
	}
	
	public static void settest(ExtentTest actualTest) {
		test.set(actualTest);		
	}
	
	public static void setdriver(WebDriver actualDriver) {
		driver.set(actualDriver);
	}
}
