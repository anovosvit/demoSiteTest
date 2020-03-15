package site;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.MobilePage;
import pages.SearchResultPage;

public class DemoSite {
    private WebDriver driver;
    private HomePage homePage;
    private MobilePage mobilePage;
    private SearchResultPage searchResultPage;

    public DemoSite() {
        this.driver = new ChromeDriver();
        this.homePage = new HomePage(driver);
        this.mobilePage = new MobilePage(driver);
        this.searchResultPage = new SearchResultPage(driver);
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public MobilePage getMobilePage() {
        return mobilePage;
    }

    public SearchResultPage getSearchResultPage() {
        return searchResultPage;
    }

    public HomePage openHomePage() {
        return homePage.open();
    }

    public MobilePage openMobilePage() {
        return mobilePage.open();
    }


    public void quit() {
        driver.quit();
    }
}
