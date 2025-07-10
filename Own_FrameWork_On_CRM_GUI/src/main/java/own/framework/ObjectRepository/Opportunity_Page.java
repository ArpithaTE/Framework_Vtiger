package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunity_Page {

	WebDriver driver;

	public Opportunity_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement CreateNewOppBtn;

	public WebElement getCreateNewOppBtn() {
		return CreateNewOppBtn;
	}
}
