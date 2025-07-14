package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_New_Products_Page {
	WebDriver driver;
	public Create_New_Products_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='productname']")
	private WebElement ProductNameEdt;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement VendorLookImage;

	@FindBy(xpath = "(//input[contains(@class,'crmbutton small save')])[1]")
	private WebElement ProductSaveBtn;

	public WebElement getProductNameEdt() {
		return ProductNameEdt;
	}

	public WebElement getVendorLookImage() {
		return VendorLookImage;
	}

	public WebElement getProductSaveBtn() {
		return ProductSaveBtn;
	}

}
