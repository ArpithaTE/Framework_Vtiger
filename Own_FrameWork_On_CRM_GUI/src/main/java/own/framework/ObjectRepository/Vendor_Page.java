package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendor_Page {
	WebDriver driver;

	public Vendor_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewVendorIcon;

	public WebElement getCreateNewVendorIcon() {
		return createNewVendorIcon;
	}
}