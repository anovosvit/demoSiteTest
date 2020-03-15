package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageClass extends BasePageClass {
    @FindBy(className = "welcome-msg")
    WebElement welcomeMessage;

    @FindBy(tagName = "h2")
    WebElement pageInfoText;

    @FindBy(xpath = "//*[@id='nav']//a")
    List<WebElement> menuItems;

    @FindBy(xpath = "//span[contains(text(), 'Account')]")
    WebElement accountLink;

    @FindBy(xpath = "//span[contains(text(), 'Cart')]")
    WebElement cartLink;

    @FindBy(xpath = "//input[@id='search']")
    WebElement searchInput;

    private String url = "http://live.demoguru99.com/";

    public HomePageClass(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePageClass open() {
        driver.get(url);
        return this;
    }

    public boolean isOnThisPage() {
        return driver.findElements(By.xpath("//*[@id='nav']//a")).size() > 0;
    }

    public String getPageInfoText() {
        return pageInfoText.getText();
    }

    public String getWelcomeText() {
        return welcomeMessage.getText();
    }

    public MobilePageClass clickMobileLink() {
        menuItems.get(0).click();
        return new MobilePageClass(driver);
    }
}
