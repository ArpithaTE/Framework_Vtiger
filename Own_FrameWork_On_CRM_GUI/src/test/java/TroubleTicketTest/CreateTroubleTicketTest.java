package TroubleTicketTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import own.framework.GenericUtility.BaseClassOwn;
import own.framework.ObjectRepository.Contact_Created_Page;
import own.framework.ObjectRepository.Contact_LookUp_Page;
import own.framework.ObjectRepository.Contacts_Page;
import own.framework.ObjectRepository.Create_New_Contact_Page;
import own.framework.ObjectRepository.Create_New_Products_Page;
import own.framework.ObjectRepository.Create_New_Trouble_Ticket_Page;
import own.framework.ObjectRepository.Home_Page;
import own.framework.ObjectRepository.Product_LookUp_Page;
import own.framework.ObjectRepository.Products_Created_Page;
import own.framework.ObjectRepository.Products_Page;
import own.framework.ObjectRepository.Trouble_Ticket_Created_Page;
import own.framework.ObjectRepository.Trouble_Ticket_Page;

public class CreateTroubleTicketTest extends BaseClassOwn {
	@Test
	public void createTroubleTicket() throws Exception { 
		// read test script data from excel file
		String ContactName = Elib.getDataFromExcel("OwnTest", 16, 2) + Jlib.getRandomNumber();
		String ProductName = Elib.getDataFromExcel("OwnTest", 16, 3) + Jlib.getRandomNumber();
		String TroubleTicketTitle = Elib.getDataFromExcel("OwnTest", 16, 4) +Jlib.getRandomNumber();

		// Synchronize using Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Navigate to Contact module
		Home_Page Hp = new Home_Page(driver);
		Hp.getContactLink().click();

		// click on create Contact button
		Contacts_Page ConP = new Contacts_Page(driver);
		ConP.getCreateNewContactBtn().click();

		// Enter all the details and create new Contact

		Create_New_Contact_Page CNConP = new Create_New_Contact_Page(driver);
		CNConP.getLastNameEdt().sendKeys(ContactName);
		CNConP.getSaveContactBtn().click();

		// verify header msg expected result
		Contact_Created_Page ConCP = new Contact_Created_Page(driver);
		String Contactheaderinfo = ConCP.getContactHeaderText().getText();
		if (Contactheaderinfo.contains(ContactName)) {
			System.out.println(ContactName + " org is Created==PASS");
		} else {
			System.out.println(ContactName + " org is not created==FAIL");
		}

		// Navigate to Products module
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
			System.out.println(ProductName + " product is Created==PASS");
		} else {
			System.out.println(ProductName + " product is not created==FAIL");
		}

		// navigate to Trouble ticket and click on create new trouble ticket
		Hp.getTroubleTicketLink().click();
		Trouble_Ticket_Page TrobTP = new Trouble_Ticket_Page(driver);
		TrobTP.getCreateNewTroubleTicketIcon().click();

		// enter all the mandatory fields and create Trouble ticket
		Create_New_Trouble_Ticket_Page CNTrobTP = new Create_New_Trouble_Ticket_Page(driver);
		CNTrobTP.getTroubleTicketTitle().sendKeys(TroubleTicketTitle);
		// CONTACTS
		CNTrobTP.getTroubleTicketContactLookUpIcon().click();
		// Switch Window
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String win : allWindows) {
			if (!win.equals(parentWindow)) {
				driver.switchTo().window(win);
				break;
			}
		}
		Contact_LookUp_Page ConLUP = new Contact_LookUp_Page(driver);
		ConLUP.getContactSearchField().sendKeys(ContactName);
		ConLUP.getContactSearchBtn().click();
		driver.findElement(By.xpath("//a[@id='1' and contains(.,'"+ContactName+"')]")).click();

		// Switch back
		driver.switchTo().window(parentWindow);

		// PRODUCTS
		CNTrobTP.getTroubleTicketProductLookUpIcon().click();
		
		// Switch Window
		String parentWindow1 = driver.getWindowHandle();
		Set<String> allWindows1= driver.getWindowHandles();
		for (String win1 : allWindows1) {
			if (!win1.equals(parentWindow1)) {
				driver.switchTo().window(win1);
				break;
			}
		}
		Product_LookUp_Page ProLUP = new Product_LookUp_Page(driver);
		ProLUP.getProductSearchTextField().sendKeys(ProductName);
		ProLUP.getProductSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + ProductName + "']")).click();

		// Switch back
		driver.switchTo().window(parentWindow);
		CNTrobTP.getTroubleTicketSaveBtn().click();

		// verify header msg expected result
		Trouble_Ticket_Created_Page TrobTCP = new Trouble_Ticket_Created_Page(driver);
		String TrobTicketHeaderinfo = TrobTCP.getToubleTicketHeaderInfo().getText();
		if (TrobTicketHeaderinfo.contains(TroubleTicketTitle)) {
			System.out.println(TroubleTicketTitle + " TroubleTicket header is verrified==PASS");
		} else {
			System.out.println(TroubleTicketTitle + " TroubleTicket header is notverrified==FAIL");
		}

		// verify Product info expected resulted
		String actContactName = driver.findElement(By.xpath("//td[@class='dvtCellInfo' and contains(.,'"+ContactName+"')]")).getText();
//		String actContactName = TrobTCP.getToubleTicketContactInfo().getText();

		if (actContactName.contains(ContactName)) {
			System.out.println(ContactName + " TroubleTicket with Contact is verrified==PASS");
		} else {
			System.out.println(ContactName + " TroubleTicket with Contact is not notverrified==FAIL");
		}

		// verify Product info expected resulted
		String actProductName = TrobTCP.getToubleTicketProductInfo().getText();
		if (actProductName.contains(ProductName)) {
			System.out.println(ProductName + " TroubleTicket with Product is verrified==PASS");
		} else {
			System.out.println(ProductName + " TroubleTicket with Product is not notverrified==FAIL");
		}

	}

}
