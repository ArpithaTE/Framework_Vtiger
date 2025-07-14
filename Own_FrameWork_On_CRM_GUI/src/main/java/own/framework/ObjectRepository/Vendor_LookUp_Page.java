package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendor_LookUp_Page {
	WebDriver driver;

	public Vendor_LookUp_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='search_text']")        //doubt
	private WebElement vendorLookUpSearchTextField;
	
	@FindBy(xpath = "(//input[contains(@class,'crmbutton small create')])[1]")
	private WebElement vendorLookUpSearchBtn;

	public WebElement getVendorLookUpSearchTextField() {
		return vendorLookUpSearchTextField;
	}

	public WebElement getVendorLookUpSearchBtn() {
		return vendorLookUpSearchBtn;
	}
	
	
}
