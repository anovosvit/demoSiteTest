import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MobilePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobilePageTest extends TestBase{
    MobilePage mobilePage = demoSite.getMobilePage();


    @BeforeEach
    void openHomePage() {
        demoSite.getMobilePage();
    }

    @Test
    @DisplayName("Page Title")
    void checkTitle() {
        String expectedTitle = "Mobile";
        String actualTitle = mobilePage.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }
}
