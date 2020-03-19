package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[contains(text(),'Ship to this address')]")
    WebElement thisAddressDelivery;

    @FindBy(xpath = "//button[@title=\"Continue\"]")
    WebElement continueFirstButton;

    @FindBy(xpath = "//button[@onclick=\"shippingMethod.save()\"]")
    WebElement continueShippingButton;

    @FindBy(id = "p_method_checkmo")
    WebElement cashPayment;

    @FindBy(xpath = "//button[@onclick=\"payment.save()\"]")
    WebElement continuePaymentButton;

    @FindBy(xpath = "//button[@class=\"button btn-checkout\"]")
    WebElement placeOrderButton;

    @FindBy(id = "review-buttons-container")
    WebElement review;

//    @FindBy(tagName = "h1")
//    WebElement successOrderMessage;
//
//    @FindBy(tagName = "h2")
//    WebElement thankYouMessage;
//
//    @FindBy(xpath = "//div[@class='main-container col1-layout']//p[1]")
//    WebElement yourOrderMessage;

    public void selectThisAddress() {
        thisAddressDelivery.click();
    }

    public void clickContinue() {
        continueFirstButton.click();
    }

    public void clickShippingContinue() {
        continueShippingButton.click();
    }

    public void selectCashPayment() {
        cashPayment.click();
    }

    public void clickPaymentButton() {
        continuePaymentButton.click();
    }

    public OrderPage clickPlaceOrder() {
        review.click();
        placeOrderButton.click();
        return new OrderPage(driver);
    }
}
