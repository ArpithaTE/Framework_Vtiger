package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Create_New_Opportunity_Page {
	WebDriver driver;

	public Create_New_Opportunity_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "potentialname")
	private WebElement OpportunityNameEdt;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement relatedToLookupImage;
	
	@FindBy(id = "related_to_type")
	private WebElement RelatedToDropdown;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement OppSaveBtn;

	public WebElement getOppSaveBtn() {
		return OppSaveBtn;
	}

	public WebElement getOpportunityNameEdt() {
		return OpportunityNameEdt;
	}

	public WebElement getRelatedToLookupImage() {
		return relatedToLookupImage;
	}

	public WebElement getRelatedToDropdown() {
		return RelatedToDropdown;
	}
	public void selectFromRelatedToDropdown(String Contacts) {
		Select sel= new Select(RelatedToDropdown);
		sel.selectByValue(Contacts);
	}
	
	
	
	
	
	
	
	
	
	
}