import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.MobilePage;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobilePageTest extends TestBase{
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
        String catalogItemName = mobilePage.getItemName();
        String price;
        String oldPrice = "";
        if (mobilePage.isSpecialPrice()) {
            price = mobilePage.getSpecialPrice();
            oldPrice = mobilePage.getOldPrice();
        }
        else {
            price = mobilePage.getRegularPrice();
        }

        mobilePage.goToItemInfoPage();
        //TODO: дописать проверку на странице товара
    }

    @Test
    @DisplayName("Sort By Name")
    void checkSortByName() {
        List<String> itemNames = mobilePage.getItemNames();
        mobilePage.sortBy();
        mobilePage.refresh();
        List<String> sortItemNames = mobilePage.getItemNames();
        Collections.sort(itemNames);
        assertEquals(itemNames, sortItemNames);
    }


}
