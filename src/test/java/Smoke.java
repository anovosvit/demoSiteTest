import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Smoke extends TestBase {
    HomePage homePage = demoSite.getHomePage();

    @BeforeEach
    void openHomePage() {
        demoSite.openHomePage();
    }

    @Test
    @DisplayName("Verify that item info in catalog and item page are equal")
    void checkItemInfo() {
        MobilePage mobilePage = homePage.clickMobileLink();
        mobilePage.makeListView();
        String itemName = mobilePage.getItemName();
        String price = mobilePage.getRegularPrice();
        String itemDescription = mobilePage.getItemDescription();

        ItemInfoPage itemInfoPage = mobilePage.clickLearnMore();

        String itemNameInfo = itemInfoPage.getItemName();
        String itemDescriptionInfo = itemInfoPage.getItemDescription();
        String itemPriceInfo = itemInfoPage.getItemPrice();

        assertEquals(itemName, itemNameInfo);
        assertTrue(itemDescription.contains(itemDescriptionInfo));
        assertEquals(price, itemPriceInfo);
    }

    @Test
    @Disabled
    @DisplayName("Add to wishlist")
    void addToWishList() {
        //Login
        //Go to mobile
        //add to wish list
    }

    @ParameterizedTest(name = "Create order")
    @CsvSource({
            "lyonka1@mail.ru, voPtaf-qezjih-hephy9"
    })
    void createOrder(String email, String password) {
        LoginPage loginPage = demoSite.openLoginPage();
        loginPage.fillOutEmailInput(email);
        loginPage.fillOutPasswordInput(password);
        loginPage.clickLogin();
        assertEquals("MY DASHBOARD", loginPage.getPageInfo());

        MobilePage mobilePage = loginPage.goToMobile();
        CartPage cartPage = mobilePage.addToCart();
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectThisAddress();
        checkoutPage.clickContinue();
        checkoutPage.clickShippingContinue();

        checkoutPage.selectCashPayment();
        checkoutPage.clickPaymentButton();
        OrderPage orderPage = checkoutPage.clickPlaceOrder();

        assertEquals("YOUR ORDER HAS BEEN RECEIVED.", orderPage.getSuccessOrderMessage());
        assertEquals("Thank you for your purchase!", orderPage.getThankYouMessage());
        assertTrue(orderPage.getYourOrderMessage().contains("Your order # is: "));
    }

}
