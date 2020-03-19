package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(tagName = "h1")
    WebElement pageInfo;

    @FindBy(xpath = "//a[@title='Create an Account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@id='send2']")
    WebElement loginButton;

    @FindBy(className = "validation-advice")
    WebElement validateMessage;

    @FindBy(xpath = "//li[@class='error-msg']")
    WebElement invalidMessage;

    @FindBy(xpath = "//a[contains(text(),'Mobile')]")
    WebElement gotoMobileLink;

    private String url = "http://live.demoguru99.com/index.php/customer/account/login/";

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        driver.get(url);
        return this;
    }

    public String getPageInfo() {
        return pageInfo.getText();
    }

    public CreateAccountPage clickOnCreateAccountButton() {
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }

    public void fillOutEmailInput(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void fillOutPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getValidateMessage() {
        return validateMessage.getText();
    }

    public String getInvalidMessage() {
        return invalidMessage.getText();
    }

    public MobilePage goToMobile() {
        gotoMobileLink.click();
        return new MobilePage(driver);
    }
}
