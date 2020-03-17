package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(tagName = "h2")
    WebElement pageInfoText;

    @FindBy(xpath = "//*[@id='nav']//a")
    List<WebElement> menuItems;

    @FindBy(xpath = "//input[@id='search']")
    WebElement searchInput;

    String url = "http://live.demoguru99.com/";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage open() {
        driver.get(url);
        return this;
    }

    public boolean isOnThisPage() {
        return driver.findElements(By.xpath("//*[@id='nav']//a")).size() > 0;
    }

    public String getPageInfoText() {
        return pageInfoText.getText();
    }


    public MobilePage clickMobileLink() {
        menuItems.get(0).click();
        return new MobilePage(driver);
    }

    public SearchResultPage searchItem(String searchText) {
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }

}
