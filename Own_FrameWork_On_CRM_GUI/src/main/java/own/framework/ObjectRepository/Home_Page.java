package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	WebDriver driver;

	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "Opportunities")
	private WebElement OpportunityLink;

	@FindBy(linkText = "Products")
	private WebElement ProductsLink;

	@FindBy(linkText = "Trouble Tickets")
	private WebElement TroubleTicketLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImage;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getOpportunityLink() {
		return OpportunityLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getTroubleTicketLink() {
		return TroubleTicketLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getAdministratorImage() {
		return administratorImage;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
}
