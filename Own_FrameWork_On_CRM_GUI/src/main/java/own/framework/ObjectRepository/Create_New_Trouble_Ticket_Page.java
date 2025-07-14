package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_New_Trouble_Ticket_Page {
	WebDriver driver;

	public Create_New_Trouble_Ticket_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@name='ticket_title']")
	private WebElement TroubleTicketTitle;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement TroubleTicketContactLookUpIcon;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[2]")
	private WebElement TroubleTicketProductLookUpIcon;

	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement TroubleTicketSaveBtn;

	public WebElement getTroubleTicketTitle() {
		return TroubleTicketTitle;
	}

	public WebElement getTroubleTicketContactLookUpIcon() {
		return TroubleTicketContactLookUpIcon;
	}

	public WebElement getTroubleTicketProductLookUpIcon() {
		return TroubleTicketProductLookUpIcon;
	}

	public WebElement getTroubleTicketSaveBtn() {
		return TroubleTicketSaveBtn;
	}

}
