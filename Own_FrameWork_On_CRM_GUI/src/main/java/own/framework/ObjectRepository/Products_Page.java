package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products_Page {
	WebDriver driver;

	public Products_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement ProductLookUpImage;

	public WebElement getProductLookUpImage() {
		return ProductLookUpImage;
	}
}
