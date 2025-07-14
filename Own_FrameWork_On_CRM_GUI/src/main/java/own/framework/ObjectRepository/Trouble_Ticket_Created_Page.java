package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Trouble_Ticket_Created_Page {
	WebDriver driver;

	public Trouble_Ticket_Created_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement ToubleTicketHeaderInfo;
	
	//a[contains(.,'AMMU')]
	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=DetailView&record=3855']")
	private WebElement ToubleTicketContactInfo;

	@FindBy(xpath = "//td[contains(@id,'mouseArea_Product Name')]")
	private WebElement ToubleTicketProductInfo;

	public WebElement getToubleTicketHeaderInfo() {
		return ToubleTicketHeaderInfo;
	}

	public WebElement getToubleTicketContactInfo() {
		return ToubleTicketContactInfo;
	}

	public WebElement getToubleTicketProductInfo() {
		return ToubleTicketProductInfo;
	}

	
}
