package site;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class DemoSite {
    private WebDriver driver;
    private HomePage homePage;
    private MobilePage mobilePage;
    private SearchResultPage searchResultPage;
    private ItemInfoPage itemInfoPage;
    private CartPage cartPage;
    private WishlistPage wishlistPage;

    public DemoSite() {
        this.driver = new ChromeDriver();
        this.homePage = new HomePage(driver);
        this.mobilePage = new MobilePage(driver);
        this.searchResultPage = new SearchResultPage(driver);
        this.itemInfoPage = new ItemInfoPage(driver);
        this.cartPage = new CartPage(driver);
        this.wishlistPage = new WishlistPage(driver);
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

    public ItemInfoPage getItemInfoPage() {
        return itemInfoPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public WishlistPage getWishlistPage() {
        return wishlistPage;
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
