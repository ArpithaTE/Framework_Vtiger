package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendor_Created_Page {
	WebDriver driver;

	public Vendor_Created_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "lvtHeaderText")
	private WebElement vendorHeaderText;

	public WebElement getVendorHeaderText() {
		return vendorHeaderText;
	}
}