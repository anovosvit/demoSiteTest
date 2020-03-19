import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CartPage;
import pages.MobilePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPageTest extends TestBase {
    CartPage cartPage = demoSite.getCartPage();

    @BeforeEach
    void openCartPage() {
        demoSite.openCartPage();
    }

    @Test
    @DisplayName("Check Title")
    void checkTitle() {
        String actualTitle = cartPage.getTitle();
        assertEquals("Shopping Cart", actualTitle);
    }

    @Test
    @DisplayName("Open empty Cart")
    void openEmptyCart() {
        String actualMessage = cartPage.getEmptyMessage();
        assertEquals("SHOPPING CART IS EMPTY", actualMessage);
    }

    @Test
    @DisplayName("Add and remove item")
    void addAndRemoveItem() {
        MobilePage mobilePage = demoSite.openMobilePage();
        CartPage cartPage = mobilePage.addToCart();
        cartPage.removeItem();
        String actualMessage = cartPage.getEmptyMessage();
        assertEquals("SHOPPING CART IS EMPTY", actualMessage);
    }

    @Test
    @DisplayName("Add null item")
    void addNullItem() {
        MobilePage mobilePage = demoSite.openMobilePage();
        CartPage cartPage = mobilePage.addToCart();
        cartPage.fillAndUpdQty("0");
        String actualMessage = cartPage.getEmptyMessage();
        assertEquals("SHOPPING CART IS EMPTY", actualMessage);
    }

    @ParameterizedTest(name = "Add {0} items")
    @ValueSource(strings = {
            "1", "500"
    })
    void addAvailableItems(String count) {
        MobilePage mobilePage = demoSite.openMobilePage();
        CartPage cartPage = mobilePage.addToCart();
        cartPage.fillAndUpdQty(count);
        assertEquals(count, cartPage.getQtyCount());
        cartPage.removeItem();
    }

    @ParameterizedTest(name = "Add more items {0} than available items")
    @ValueSource(strings = {
            "501", "1000"
    })
    void addMoreThanAvailable(String count) {
        MobilePage mobilePage = demoSite.openMobilePage();
        CartPage cartPage = mobilePage.addToCart();
        cartPage.fillAndUpdQty(count);
        assertEquals("Some of the products cannot be ordered in requested quantity.", cartPage.getErrorMessage());
        assertTrue(cartPage.getItemErrorMessage().contains("* The maximum quantity allowed for purchase is"));
        cartPage.removeItem();
    }
}
