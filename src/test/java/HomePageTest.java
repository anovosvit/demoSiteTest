import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.HomePage;
import pages.MobilePage;
import pages.SearchResultPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest extends TestBase {
    HomePage homePage = demoSite.getHomePage();
    private String titleText = "Home page";
    private String h2Text = "This is demo site for";
    private String welcome = "Default welcome msg!";

    @BeforeEach
    void openHomePage() {
        demoSite.openHomePage();
    }

    @Test
    @DisplayName("Page Title")
    void checkTitle() {
        String expectedTitle = titleText;
        String actualTitle = homePage.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    @DisplayName("Page Info Text")
    void checkPageInfoText() {
        String expectedResult = h2Text.toLowerCase().strip();
        String actualResult = homePage.getPageInfoText().toLowerCase().strip();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Welcome message")
    void checkWelcomeMessage() {
        String expectedMsg = welcome.toLowerCase();
        String actualMsg = homePage.getWelcomeText().toLowerCase();
        assertEquals(expectedMsg, actualMsg);
    }

    @Test
    @DisplayName("Go to Mobile Page")
    void goToMobilePage() {
        if (homePage.isOnThisPage()) {
            MobilePage mobilePage = homePage.clickMobileLink();
            assertEquals("Mobile", mobilePage.getTitle());
        }
    }

    @ParameterizedTest(name = "#{index} - Search with args={0}")
    @ValueSource(strings = {
            "sony",
            " ",
            "Milk - Chocolate 500ml",
            "Crab - Back Fin Meat, Canned",
            "Pastry - Butterscotch Baked"
    })
    void searchSomething(String searchString) {
        SearchResultPage searchResultPage = homePage.searchItem(searchString);
        String expectedString = String.format("SEARCH RESULTS FOR '%s'", searchString).toUpperCase();

        if (searchString.strip().isEmpty()){
            assertEquals(titleText, searchResultPage.getTitle());
        }
        else {
            assertEquals(expectedString, searchResultPage.getSearchResultText());
        }
    }

}
