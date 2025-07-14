package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_Created_Page {
	WebDriver driver;

	public Contact_Created_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement contactHeaderText;

	@FindBy(id = "mouseArea_Last Name")
	private WebElement lastNameText;

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}

	public WebElement getLastNameText() {
		return lastNameText;
	}
}