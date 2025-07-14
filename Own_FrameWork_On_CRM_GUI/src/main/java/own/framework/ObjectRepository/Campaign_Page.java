package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign_Page {

	WebDriver driver;

	public Campaign_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateNewCampaignIcon;

	public WebElement getCreateNewCampaignIcon() {
		return CreateNewCampaignIcon;
	}
}