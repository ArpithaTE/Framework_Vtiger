package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_LookUp_Page {

	WebDriver driver;

	public Organization_LookUp_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_text")
	private WebElement orglookUpSearchTextField;

	@FindBy(name = "search")
	private WebElement orglookUpSearchBtn;

	public WebElement getOrglookUpSearchTextField() {
		return orglookUpSearchTextField;
	}

	public WebElement getOrglookUpSearchBtn() {
		return orglookUpSearchBtn;
	}

}
