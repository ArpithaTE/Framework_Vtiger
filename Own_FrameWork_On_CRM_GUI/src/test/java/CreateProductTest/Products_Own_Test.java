package CreateProductTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import own.framework.GenericUtility.BaseClassOwn;
import own.framework.ObjectRepository.Create_New_Products_Page;
import own.framework.ObjectRepository.Create_New_Vendor_Page;
import own.framework.ObjectRepository.Home_Page;
import own.framework.ObjectRepository.Products_Created_Page;
import own.framework.ObjectRepository.Products_Page;
import own.framework.ObjectRepository.Vendor_Created_Page;
import own.framework.ObjectRepository.Vendor_LookUp_Page;
import own.framework.ObjectRepository.Vendor_Page;

public class Products_Own_Test extends BaseClassOwn {
	@Test
	public void createProductsTest() throws Exception {
		// read test script data from excel file
		String ProductName = Elib.getDataFromExcel("OwnTest", 7, 2) + Jlib.getRandomNumber();

		// Synchronize using Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Navigate to Products module
		Home_Page Hp = new Home_Page(driver);
		Hp.getProductsLink().click();

		// click on create Products button
		Products_Page ProP = new Products_Page(driver);
		ProP.getProductLookUpImage().click();

		// Enter all the details and create new Products

		Create_New_Products_Page CNProP = new Create_New_Products_Page(driver);
		CNProP.getProductNameEdt().sendKeys(ProductName);
		CNProP.getProductSaveBtn().click();

		// verify header msg expected result
		Products_Created_Page ProCP = new Products_Created_Page(driver);
		String Productheaderinfo = ProCP.getProductHeaderText().getText();
		if (Productheaderinfo.contains(ProductName)) {
			System.out.println(ProductName + " Producted is Created==PASS");
		} else {
			System.out.println(ProductName + " Producted is not created==FAIL");
		}
	}

	@Test
	public void createProductsWithVendorTest() throws Exception {
		// read test script data from excel file
		String ProductName = Elib.getDataFromExcel("OwnTest", 10, 2) + Jlib.getRandomNumber();
		String VendorName = Elib.getDataFromExcel("OwnTest", 10, 3) + Jlib.getRandomNumber();

		// Synchronize using Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Navigate to vendor module
		Home_Page Hp = new Home_Page(driver);
		Hp.navigateToVendorLink();

		// click on Create new vendor
		Vendor_Page VenP = new Vendor_Page(driver);
		VenP.getCreateNewVendorIcon().click();
		// enter all the mandatory details and create vendor
		Create_New_Vendor_Page CNVenP = new Create_New_Vendor_Page(driver);
		CNVenP.getVendorNameEdt().sendKeys(VendorName);
		CNVenP.getVendorsaveBtn().click();

		// verify Vendor header text expected result
		Vendor_Created_Page VenCP = new Vendor_Created_Page(driver);
		String Vendorheaderinfo = VenCP.getVendorHeaderText().getText();
		if (Vendorheaderinfo.contains(VendorName)) {
			System.out.println(VendorName + " vendor is Created==PASS");
		} else {
			System.out.println(VendorName + " vendor is not created==FAIL");
		}

		Hp.getProductsLink().click();
		// navigate to products tab
		Products_Page ProP = new Products_Page(driver);
		ProP.getProductLookUpImage().click();

		// Enter all the details and create new Products
		Create_New_Products_Page CNProP = new Create_New_Products_Page(driver);
		CNProP.getProductNameEdt().sendKeys(ProductName);
		CNProP.getVendorLookImage().click();

		// Switch Window
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String win : allWindows) {
			if (!win.equals(parentWindow)) {
				driver.switchTo().window(win);
				break;
			}
		}
		Vendor_LookUp_Page VenLUPP = new Vendor_LookUp_Page(driver);
		VenLUPP.getVendorLookUpSearchTextField().sendKeys(VendorName);
		VenLUPP.getVendorLookUpSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + VendorName + "']")).click();

		// Switch back
		driver.switchTo().window(parentWindow);
		CNProP.getProductSaveBtn().click();

		// verify header msg expected result
//
		Products_Created_Page ProCP = new Products_Created_Page(driver);
		String Productheaderinfo = ProCP.getProductHeaderText().getText();
//		String Productheaderinfo = driver.findElement(By.xpath("//a[contains(.,'"+ProductName+"')]")).getText();
		if (Productheaderinfo.contains(ProductName)) {
			System.out.println(ProductName + " Product is Created==PASS");
		} else {
			System.out.println(ProductName + " Product is not created==FAIL");
		}
//		String VendorInfo = driver.findElement(By.xpath("//a[contains(.,'"+VendorName+"')]")).getText();
		String VendorInfo = ProCP.getProductVendorName().getText();
		if (VendorInfo.contains(VendorName)) {
			System.out.println(VendorName + " vendor is Created==PASS");
		} else {
			System.out.println(VendorName + " vendor is not created==FAIL");
		}
	}
}
