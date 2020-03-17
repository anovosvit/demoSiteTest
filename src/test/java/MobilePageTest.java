import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CartPage;
import pages.MobilePage;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobilePageTest extends TestBase {
    MobilePage mobilePage = demoSite.getMobilePage();
    private String welcome = "Default welcome msg!";

    @BeforeEach
    void openHomePage() {
        demoSite.openMobilePage();
    }

    @Test
    @DisplayName("Page Title")
    void checkTitle() {
        String expectedTitle = "Mobile";
        String actualTitle = mobilePage.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    @DisplayName("Welcome message")
    void checkWelcomeMessage() {
        String expectedMsg = welcome.toLowerCase();
        String actualMsg = mobilePage.getWelcomeText().toLowerCase();
        assertEquals(expectedMsg, actualMsg);
    }

    @Test
    @Disabled
    @DisplayName("Compare item Info (this page and item page)")
    void compareItemInfo() {
        //TODO: дописать проверку на странице товара
    }

    @Test
    @DisplayName("Sort By Name (Grid Mode)")
    void checkSortByNameInGridMode() {
        mobilePage.makeGridView();
        List<String> itemNames = mobilePage.getItemNames();
        mobilePage.sortBy("Name");
        List<String> sortItemNames = mobilePage.getItemNames();
        Collections.sort(itemNames);
        assertEquals(itemNames, sortItemNames);
    }

    @Test
    @DisplayName("Sort By Name (List Mode)")
    void checkSortByNameInListMode() {
        mobilePage.makeListView();
        List<String> itemNames = mobilePage.getItemNames();
        mobilePage.sortBy("Name");
        List<String> sortItemNames = mobilePage.getItemNames();
        Collections.sort(itemNames);
        assertEquals(itemNames, sortItemNames);
    }

    @Test
    @Disabled
    @DisplayName("Sort By Price")
    void checkSortByPrice() {
        mobilePage.sortBy("Price");
    }

    @ParameterizedTest(name = "Select {0} result per Page (Grid Mode)")
    @ValueSource(strings = {
            "12", "24",
            "36"
    })
    void selectResultPerPage(String numResult) {
        mobilePage.makeGridView();
        mobilePage.selectResultPerPage(numResult);
        checkWelcomeMessage();
    }

    @ParameterizedTest(name = "Select {0} result per Page (List Mode)")
    @ValueSource(strings = {
            "5", "10",
            "15", "20", "25"
    })
    void selectResultPerListModePage(String numResult) {
        mobilePage.makeListView();
        mobilePage.selectResultPerPage(numResult);
        checkWelcomeMessage();
    }

    @Test
    @Disabled
    @DisplayName("Add all items to cart (Grid Mode)")
    void addAllToCart() {
        mobilePage.makeGridView();
        CartPage cartPage = mobilePage.addToCart();
        String actualInfo = cartPage.getPageInfo();
        String expectedInfo = "Shopping Cart";
        assertEquals(expectedInfo, actualInfo);
    }

    @Test
    @DisplayName("Add to compare")
    void addToCompare() {
        mobilePage.addToCompare();
        String message = mobilePage.getSuccessCompareText();
        assertTrue(message.contains("has been added to comparison list."));
    }

}
