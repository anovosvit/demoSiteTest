package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MobilePage extends BasePage {
    private String url = "http://live.demoguru99.com/index.php/mobile.html";

    @FindBy(xpath = "//select[@title = 'Sort By']")
    WebElement sortBySelect;

    @FindBy(xpath = "//*[@title = 'Grid']")
    WebElement viewAsGridMode;

    @FindBy(xpath = "//*[@title = 'List']")
    WebElement viewAsListMode;

    @FindBy(xpath = "//*[@title = 'Results per page']")
    WebElement resultPerPageSelect;

    @FindBy(className = "item last")
    List<WebElement> itemsList;

    @FindBy(tagName = "h2")
    WebElement itemName;

    @FindBy(className = "button btn-cart")
    WebElement addToCartButton;

    @FindBy(className = "link-wishlist")
    WebElement addToWishListLink;

    @FindBy(className = "link-compare")
    WebElement addToCompareLink;

    public MobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MobilePage open() {
        driver.get(url);
        return this;
    }



}
