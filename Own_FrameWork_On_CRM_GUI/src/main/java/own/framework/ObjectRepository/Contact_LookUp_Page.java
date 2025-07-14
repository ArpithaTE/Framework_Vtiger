package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_LookUp_Page {

	public Contact_LookUp_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@name='search_text'])[1]")
	private WebElement ContactSearchField;
	
	@FindBy(xpath = "(//input[contains(@class,'crmbutton small create')])[1]")
	private WebElement ContactSearchBtn;

	public WebElement getContactSearchField() {
		return ContactSearchField;
	}

	public WebElement getContactSearchBtn() {
		return ContactSearchBtn;
	}

}
