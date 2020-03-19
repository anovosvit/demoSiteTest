package site;

import helper.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class DemoSite {
    EventFiringWebDriver driver;
    private HomePage homePage;
    private MobilePage mobilePage;
    private SearchResultPage searchResultPage;
    private ItemInfoPage itemInfoPage;
    private CartPage cartPage;
    private WishlistPage wishlistPage;
    private LoginPage loginPage;
    private CreateAccountPage createAccountPage;
    private CheckoutPage checkoutPage;

    public DemoSite() {
        this.driver = new EventFiringWebDriver(new ChromeDriver());
        this.driver.register(new EventHandler());
        //this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        this.homePage = new HomePage(driver);
        this.mobilePage = new MobilePage(driver);
        this.searchResultPage = new SearchResultPage(driver);
        this.itemInfoPage = new ItemInfoPage(driver);
        this.cartPage = new CartPage(driver);
        this.wishlistPage = new WishlistPage(driver);
        this.loginPage = new LoginPage(driver);
        this.createAccountPage = new CreateAccountPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public MobilePage getMobilePage() {
        return mobilePage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public HomePage openHomePage() {
        return homePage.open();
    }

    public MobilePage openMobilePage() {
        return mobilePage.open();
    }

    public CartPage openCartPage() {
        return cartPage.open();
    }

    public LoginPage openLoginPage() {
        return loginPage.open();
    }

    public void quit() {
        driver.quit();
    }
}
