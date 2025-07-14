package CampaignTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import own.framework.GenericUtility.BaseClassOwn;
import own.framework.ObjectRepository.Campaign_Created_Page;
import own.framework.ObjectRepository.Campaign_Page;
import own.framework.ObjectRepository.Create_New_Campaign_Page;
import own.framework.ObjectRepository.Create_New_Products_Page;
import own.framework.ObjectRepository.Home_Page;
import own.framework.ObjectRepository.Product_LookUp_Page;
import own.framework.ObjectRepository.Products_Created_Page;
import own.framework.ObjectRepository.Products_Page;

public class CreateCampaignTest extends BaseClassOwn {

	@Test
	public void createProductsTest() throws Exception {
		// read test script data from excel file
		String CampaignName = Elib.getDataFromExcel("OwnTest", 13, 2) + Jlib.getRandomNumber();
		String ProductName = Elib.getDataFromExcel("OwnTest", 13, 3) + Jlib.getRandomNumber();

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
			System.out.println(ProductName + " Product is Created==PASS");
		} else {
			System.out.println(ProductName + " Product is not created==FAIL");
		}
		// click on Campaign Link under More>Marketing
		Hp.navigateToCampaignLink();
		// Click on Create New campaign Lookup image
		Campaign_Page CamP = new Campaign_Page(driver);
		CamP.getCreateNewCampaignIcon().click();

		// enter all the mandatory fields and create campaign with product
		Create_New_Campaign_Page CNCamP = new Create_New_Campaign_Page(driver);
		CNCamP.getCampaignTitleEdt().sendKeys(CampaignName);
		CNCamP.getProductsLookUpIcon().click();

		// Switch window
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String win : allWindows) {
			if (!win.equals(parentWindow)) {
				driver.switchTo().window(win);
				break;
			}
		}
		Product_LookUp_Page ProLUP = new Product_LookUp_Page(driver);
		ProLUP.getProductSearchTextField().sendKeys(ProductName);
		ProLUP.getProductSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + ProductName + "']")).click();

		// Switch to Parent Window
		driver.switchTo().window(parentWindow);
		CNCamP.getCampaignSaveBtn().click();

		// verify header msg expected result
		Campaign_Created_Page CamCP = new Campaign_Created_Page(driver);
		String Campaignheaderinfo = CamCP.getCampaignHeaderText().getText();
		if (Campaignheaderinfo.contains(CampaignName)) {
			System.out.println(CampaignName + " Campaign header is verrified==PASS");
		} else {
			System.out.println(CampaignName + " Campaign header is notverrified==FAIL");
		}

		// verify Product info expected resulted
		String actProductName = CamCP.getCampaignProcuctLinked().getText();
		if (actProductName.contains(ProductName)) {
			System.out.println(ProductName + " Campaign with Product is verrified==PASS");
		} else {
			System.out.println(ProductName + " Campaign with Product is not notverrified==FAIL");
		}
	}
}