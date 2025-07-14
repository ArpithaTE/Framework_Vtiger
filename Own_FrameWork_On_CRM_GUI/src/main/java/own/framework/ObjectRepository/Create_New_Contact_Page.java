package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_New_Contact_Page {
	WebDriver driver;

	public Create_New_Contact_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveContactBtn;

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveContactBtn() {
		return saveContactBtn;
	}

}
