package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_New_Vendor_Page {
	WebDriver driver;

	public Create_New_Vendor_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='vendorname']")
	private WebElement vendorNameEdt;

	@FindBy(xpath = "(//input[contains(@class,'crmbutton small save')])[1]")
	private WebElement vendorsaveBtn;

	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}

	public WebElement getVendorsaveBtn() {
		return vendorsaveBtn;
	}
}
