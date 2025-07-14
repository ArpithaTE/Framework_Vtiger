package CreateOpportunityTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import own.framework.GenericUtility.BaseClassOwn;
import own.framework.GenericUtility.Utility_Class_Object_Own;
import own.framework.GenericUtility.WebDriver_Utility_Own;
import own.framework.ObjectRepository.Contact_Created_Page;
import own.framework.ObjectRepository.Contact_LookUp_Page;
import own.framework.ObjectRepository.Contacts_Page;
import own.framework.ObjectRepository.Create_New_Contact_Page;
import own.framework.ObjectRepository.Create_New_Opportunity_Page;
import own.framework.ObjectRepository.Create_New_Organization_Page;
import own.framework.ObjectRepository.Home_Page;
import own.framework.ObjectRepository.Opportunity_Created_Page;
import own.framework.ObjectRepository.Opportunity_Page;
import own.framework.ObjectRepository.Organization_Created_Page;
import own.framework.ObjectRepository.Organization_LookUp_Page;
import own.framework.ObjectRepository.Organization_Page;

public class Opportunity_Own_Test extends BaseClassOwn {
	@Test
	public void createOppotunityWithOrganizationTest() throws Exception {
		// read test script data from excel file
		String OpportunityTitle = Elib.getDataFromExcel("OwnTest", 1, 2) + Jlib.getRandomNumber();
		String OrganizationName = Elib.getDataFromExcel("OwnTest", 1, 3) + Jlib.getRandomNumber();

		// Synchronize using Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Navigate to Organization module
		Home_Page Hp = new Home_Page(driver);
		Hp.getOrgLink().click();

		// click on create organization button
		Organization_Page Op = new Organization_Page(driver);
		Op.getCreateNewOrgButton().click();

		// Enter all the details and create new organization
		Create_New_Organization_Page CNOP = new Create_New_Organization_Page(driver);
		CNOP.getOrgnameEdt().sendKeys(OrganizationName);
		CNOP.getSaveBtn().click();

		// verify header msg expected result
		Organization_Created_Page OCP = new Organization_Created_Page(driver);
		String headerinfo = OCP.getHeaderText().getText();
		if (headerinfo.contains(OrganizationName)) {
			System.out.println(OrganizationName + " org is Created==PASS");
		} else {
			System.out.println(OrganizationName + " org is not created==FAIL");
		}

		// Navigate to Opportunity module
		Hp.getOpportunityLink().click();
		Opportunity_Page OppP = new Opportunity_Page(driver);
		OppP.getCreateNewOppBtn().click();
		Create_New_Opportunity_Page CNOppP = new Create_New_Opportunity_Page(driver);
		CNOppP.getOpportunityNameEdt().sendKeys(OpportunityTitle);
		CNOppP.getRelatedToLookupImage().click();
		// Switch Window
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String win : allWindows) {
			if (!win.equals(parentWindow)) {
				driver.switchTo().window(win);
				break;
			}
		}

		Organization_LookUp_Page OLuP = new Organization_LookUp_Page(driver);
		OLuP.getOrglookUpSearchTextField().sendKeys(OrganizationName);
		OLuP.getOrglookUpSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + OrganizationName + "']")).click();

		// Switch to Parent Window
		driver.switchTo().window(parentWindow);
		CNOppP.getOppSaveBtn().click();

		// verify header msg expected result
		Opportunity_Created_Page OppCP = new Opportunity_Created_Page(driver);
		String Oppheaderinfo = OppCP.getOpprotunityHeaderText().getText();
		if (Oppheaderinfo.contains(OpportunityTitle)) {
			System.out.println(OpportunityTitle + " Opportunity header is verrified==PASS");
		} else {
			System.out.println(OpportunityTitle + " Opportunity header is notverrified==FAIL");
		}

		// verify orgname info expected resulted
		String actOrgName = OppCP.getOrgNameInOppText().getText();
		if (actOrgName.contains(OrganizationName)) {
			System.out.println(OrganizationName + " Opportunity with org is verrified==PASS");
		} else {
			System.out.println(OrganizationName + " Opportunity with org is not notverrified==FAIL");
		}
	}

	@Test
	public void createOppotunityWithContactTest() throws Exception {
		// read test script data from excel file
		String OpportunityTitle = Elib.getDataFromExcel("OwnTest", 4, 2) + Jlib.getRandomNumber();
		String ContactName = Elib.getDataFromExcel("OwnTest", 4, 3) + Jlib.getRandomNumber();
		String RelatedToContact = Elib.getDataFromExcel("OwnTest", 4, 4);

		// Synchronize using Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Navigate to Contact module
		Home_Page Hp = new Home_Page(driver);
		Hp.getContactLink().click();
		WebDriver_Utility_Own Wlib=new WebDriver_Utility_Own(driver);
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
//		Assert.assertEquals(Contactheaderinfo, ContactName, ContactName+"contact is not created==FAIL");
		Utility_Class_Object_Own.gettest().log(Status.PASS, ContactName + " org is Created==PASS");
		if (Contactheaderinfo.contains(ContactName)) {
			System.out.println(ContactName + "  Contact is Created==PASS");
		} else {
			System.out.println(ContactName + "  Contact is not created==FAIL");
		}

		System.out.println("R:"+RelatedToContact);
		// Navigate to Opportunity module
		Hp.getOpportunityLink().click();
		Opportunity_Page OppP = new Opportunity_Page(driver);
		OppP.getCreateNewOppBtn().click();
		Create_New_Opportunity_Page CNOppP = new Create_New_Opportunity_Page(driver);
		CNOppP.getOpportunityNameEdt().sendKeys(OpportunityTitle);
		Wlib.WebElementDropDown(CNOppP.getRelatedToDropdown(), RelatedToContact);
//		CNOppP.selectFromRelatedToDropdown(RelatedToContact);
		CNOppP.getRelatedToLookupImage().click();
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
		driver.findElement(By.xpath("//a[@id='1' and contains(.,'"+ContactName+"' )]")).click();

		// Switch to Parent Window
		driver.switchTo().window(parentWindow);
		CNOppP.getOppSaveBtn().click();

		// verify header msg expected result
		Opportunity_Created_Page OppCP = new Opportunity_Created_Page(driver);
		String Oppheaderinfo = OppCP.getOpprotunityHeaderText().getText();
		if (Oppheaderinfo.contains(OpportunityTitle)) {
			System.out.println(OpportunityTitle + " Opportunity header is verrified==PASS");
		} else {
			System.out.println(OpportunityTitle + " Opportunity header is notverrified==FAIL");
		}

		// verify orgname info expected resulted
		String actConName = OppCP.getContactNameInOppText().getText();
		if (actConName.contains(ContactName)) {
			System.out.println(ContactName + " Opportunity with contact is verrified==PASS");
		} else {
			System.out.println(ContactName + " Opportunity with contact is not notverrified==FAIL");
		}
	}
}