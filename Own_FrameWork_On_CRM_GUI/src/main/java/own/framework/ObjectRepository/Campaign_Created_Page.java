package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign_Created_Page {

	WebDriver driver;

	public Campaign_Created_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement CampaignHeaderText;

	@FindBy(id = "mouseArea_Product")
	private WebElement CampaignProcuctLinked;

	public WebElement getCampaignHeaderText() {
		return CampaignHeaderText;
	}

	public WebElement getCampaignProcuctLinked() {
		return CampaignProcuctLinked;
	}
}
