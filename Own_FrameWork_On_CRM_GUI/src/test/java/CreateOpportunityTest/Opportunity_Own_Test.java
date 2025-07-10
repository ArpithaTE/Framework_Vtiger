package CreateOpportunityTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import own.framework.GenericUtility.BaseClassOwn;
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
	public void createOppotunityWithOrganization()throws Exception {
		// read test script data from excel file
		String OpportunityTitle = Elib.getDataFromExcel("Opportunity", 1, 2) + Jlib.getRandomNumber();
		String OrganizationName = Elib.getDataFromExcel("Opportunity", 1, 3) + Jlib.getRandomNumber();
//		WebDriver_Utility_Own Wlib=new WebDriver_Utility_Own();             //doubt
		// Synchronize using Implicitly wait
//		Wlib.waitForPageToLoad();
		
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
		CNOppP.getOrganizationLookupImage().click();
		// switch to child window
//		WebDriver_Utility_Own Wlib=new WebDriver_Utility_Own();
//		Wlib.switchToTabOnURL("module=Accounts&action=Popup");
//		

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
		
		driver.switchTo().window(parentWindow);
		// Wlib.switchToTabOnURL("module=Potentials");
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
		
//		// logout from application
//		Actions act=new Actions(driver);
//		act.moveToElement(Hp.getAdministratorImage()).perform();
//		Hp.getSignOutLink().click();
	}
}