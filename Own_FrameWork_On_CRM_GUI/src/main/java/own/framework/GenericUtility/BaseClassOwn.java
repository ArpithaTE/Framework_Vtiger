package own.framework.GenericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;

import own.framework.ObjectRepository.Home_Page;
import own.framework.ObjectRepository.Login_page;

@Listeners(Listner_Utility_Class.class)
public class BaseClassOwn {

	public WebDriver driver;

	// creation of object
	public File_Utility_Own Flib = new File_Utility_Own();
	public Excel_Utility_Own Elib = new Excel_Utility_Own();
	public Java_Utility_Own Jlib = new Java_Utility_Own();
	public WebDriver_Utility_Own Wlib;

	@BeforeSuite
	public void configBS() throws SQLException {
	}

	@BeforeClass
	public void configBC() throws Exception {
		String BROWSER = Flib.getDataFromPropertiesFile("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		Utility_Class_Object_Own.setdriver(driver);
		Wlib = new WebDriver_Utility_Own(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Exception {
//		Utility_Class_Object_Own.gettest().log(Status.INFO, "Login==");
		String URL = Flib.getDataFromPropertiesFile("url");
		String USERNAME = Flib.getDataFromPropertiesFile("username");
		String PASSWORD = Flib.getDataFromPropertiesFile("password");
		
		// login to Application
		Login_page Lp = new Login_page(driver);
		Lp.loginToApplication(driver, URL, USERNAME, PASSWORD);
	}

	@AfterMethod
	public void configAM() {
		System.out.println("==LogOut==");
		Home_Page Hp = new Home_Page(driver);
		Hp.logout();
	}

	@AfterClass
	public void configAC() {
		Utility_Class_Object_Own.gettest().log(Status.INFO, "Close Browse==");
		driver.quit();
	}

	@AfterSuite
	public void configAS() throws Exception {
	}
}