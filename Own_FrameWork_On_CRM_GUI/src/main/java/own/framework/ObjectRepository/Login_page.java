package own.framework.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {


	public Login_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameEdit;

	@FindBy(name = "user_password")
	private WebElement passwordEdit;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void loginToApplication(WebDriver driver, String url, String username, String password) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}

	public void loginToApplication(WebDriver driver, String username, String password) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}
}
