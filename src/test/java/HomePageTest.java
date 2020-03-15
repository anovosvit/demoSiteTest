import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePageClass;
import pages.MobilePageClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest extends TestBase{
    private String titleText = "Home page";
    private String h2Text = "This is demo site for";
    private String welcome = "Default welcome msg!";
    HomePageClass homePage = demoSite.getHomePage();
    MobilePageClass mobilePage;

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
            mobilePage = homePage.clickMobileLink();
            assertEquals("Mobile", demoSite.getMobilePage().getTitle());
        }
    }
}
