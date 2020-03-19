package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    @FindBy(tagName = "h1")
    WebElement pageInfo;

    @FindBy(xpath = "//input[@class=\"input-text qty\"]")
    WebElement qty;

    @FindBy(tagName = "h1")
    WebElement emptyMessage;

    @FindBy(xpath = "//button[@title=\"Update\"]")
    WebElement updButton;

    @FindBy(xpath = "//li[@class='error-msg']")
    WebElement errorMessage;

    @FindBy(xpath = "//p[@class='item-msg error']")
    WebElement itemErrorMessage;

    @FindBy(xpath = "//td[@class=\"a-center product-cart-remove last\"]/a")
    WebElement removeItemButton;

    @FindBy(xpath = "//button[@title=\"Proceed to Checkout\"]")
    WebElement toCheckoutButton;

    String url = "http://live.demoguru99.com/index.php/checkout/cart/";

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CartPage open() {
        driver.get(url);
        return this;
    }

    public String getPageInfo() {
        return pageInfo.getText();
    }

    public String getEmptyMessage() {
        return emptyMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getItemErrorMessage() {
        return itemErrorMessage.getText();
    }

    public String getQtyCount() {
        return qty.getAttribute("value");
    }

    public CartPage removeItem() {
        removeItemButton.click();
        return this;
    }

    public CartPage fillAndUpdQty(String count) {
        qty.clear();
        qty.sendKeys(count);
        updButton.submit();
        return this;
    }


    public CheckoutPage goToCheckout() {
        toCheckoutButton.click();
        return new CheckoutPage(driver);
    }

}
