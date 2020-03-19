package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BasePage{
    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    WebElement successOrderMessage;

    @FindBy(tagName = "h2")
    WebElement thankYouMessage;

    @FindBy(xpath = "//div[@class='main-container col1-layout']//p[1]")
    WebElement yourOrderMessage;

    public String getSuccessOrderMessage() {
        return successOrderMessage.getText();
    }

    public String getThankYouMessage() {
        return thankYouMessage.getText();
    }

    public String getYourOrderMessage() {
        return yourOrderMessage.getText();
    }
}
