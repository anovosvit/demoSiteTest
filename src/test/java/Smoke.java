import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ItemInfoPage;
import pages.MobilePage;
import pages.WishlistPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Smoke extends TestBase {
    HomePage homePage = demoSite.getHomePage();;

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



}
