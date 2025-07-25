package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts_Page {
	WebDriver driver;

	public Contacts_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement CreateNewContactBtn;

	public WebElement getCreateNewContactBtn() {
		return CreateNewContactBtn;
	}

}
