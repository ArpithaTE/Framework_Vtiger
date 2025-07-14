package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunity_Created_Page {
	WebDriver driver;

	public Opportunity_Created_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement opprotunityHeaderText;

	@FindBy(xpath = "//td[@class='dvtCellInfo']/a[@title='Organizations']")
	private WebElement OrgNameInOppText;
	
	@FindBy(xpath = "//td[@class='dvtCellInfo']/a[@title='Contacts']")
	private WebElement ContactNameInOppText;
	
	public WebElement getContactNameInOppText() {
		return ContactNameInOppText;
	}

	public WebElement getOrgNameInOppText() {
		return OrgNameInOppText;
	}

	public WebElement getOpprotunityHeaderText() {
		return opprotunityHeaderText;
	}

}
