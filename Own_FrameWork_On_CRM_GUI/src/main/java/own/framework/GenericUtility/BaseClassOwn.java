package own.framework.GenericUtility;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import own.framework.ObjectRepository.Home_Page;
import own.framework.ObjectRepository.Login_page;

public class BaseClassOwn {

	public WebDriver driver = null;

	// creation of object
	public DataBase_Utility_Own Dlib = new DataBase_Utility_Own();
	public File_Utility_Own Flib = new File_Utility_Own();
	public Excel_Utility_Own Elib = new Excel_Utility_Own();
	public Java_Utility_Own Jlib = new Java_Utility_Own();
	public WebDriver_Utility_Own Wlib;

	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("===Connect To DB, Report Config===");
		Dlib.getDBconnection();
	}

	@BeforeClass
	public void configBC() throws Exception {
		System.out.println("==Launch Browser==");
		String BROWSER = Flib.getDataFromPropertiesFile("browser");
		System.out.println("Browser>>>>" + BROWSER);
		if (BROWSER.equals("chrome")) {
			driver = new  ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		Wlib=new WebDriver_Utility_Own(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Exception {
		System.out.println("==Login==");
		String URL = Flib.getDataFromPropertiesFile("url");
		String USERNAME = Flib.getDataFromPropertiesFile("username");
		String PASSWORD = Flib.getDataFromPropertiesFile("password");
		// login to Application
		Login_page Lp = new Login_page(driver);
		Lp.loginToApplication(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAM() {
		System.out.println("==LogOut==");
		// logout from application
		Home_Page Hp = new Home_Page(driver);
		Actions act = new Actions(driver);
		act.moveToElement(Hp.getAdministratorImage()).perform();
		Hp.getSignOutLink().click();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		System.out.println("==close browse==");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() throws Exception {
		System.out.println("===close DB, Report BackUp");
		Dlib.closeDBconnection();

	}

}