package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products_Created_Page {
	WebDriver driver;

	public Products_Created_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "lvtHeaderText")
	private WebElement ProductHeaderText;

	@FindBy(id = "mouseArea_Vendor Name")
	private WebElement ProductVendorName;

	public WebElement getProductHeaderText() {
		return ProductHeaderText;
	}

	public WebElement getProductVendorName() {
		return ProductVendorName;
	}
	
}
