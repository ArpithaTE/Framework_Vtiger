package own.framework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_LookUp_Page {
	WebDriver driver;

	public Product_LookUp_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@name='search_text'])[1]")
	private WebElement ProductSearchTextField;

	@FindBy(xpath = "(//input[@name='search'])[1]")
	private WebElement ProductSearchBtn;

	public WebElement getProductSearchTextField() {
		return ProductSearchTextField;
	}

	public WebElement getProductSearchBtn() {
		return ProductSearchBtn;
	}

}
