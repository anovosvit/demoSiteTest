package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//span[contains(text(), 'Account')]")
    WebElement accountLink;

    @FindBy(xpath = "//span[contains(text(), 'Cart')]")
    WebElement cartLink;

    @FindBy(className = "welcome-msg")
    WebElement welcomeMessage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getWelcomeText() {
        return welcomeMessage.getText();
    }

}
