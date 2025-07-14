package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_New_Campaign_Page {
	WebDriver driver;

	public Create_New_Campaign_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='detailedViewTextBox' and @name='campaignname']")
	private WebElement CampaignTitleEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement ProductsLookUpIcon;
	
	@FindBy(xpath = "(//input[@class='crmButton small save'])[1]")
	private WebElement CampaignSaveBtn;

	public WebElement getCampaignTitleEdt() {
		return CampaignTitleEdt;
	}

	public WebElement getProductsLookUpIcon() {
		return ProductsLookUpIcon;
	}

	public WebElement getCampaignSaveBtn() {
		return CampaignSaveBtn;
	}	
}
