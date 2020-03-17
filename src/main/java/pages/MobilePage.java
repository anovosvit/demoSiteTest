package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MobilePage extends BasePage {
    @FindBy(xpath = "//*[@title = 'Grid']")
    WebElement viewAsGridMode;

    @FindBy(xpath = "//*[@title = 'List']")
    WebElement viewAsListMode;

    @FindBy(xpath = "//*[@title = 'Results per page']")
    WebElement resultPerPageSelect;

    Select selectResultPerPage;

    @FindBy(className = "item last")
    List<WebElement> itemsList;

    @FindBy(tagName = "h2")
    WebElement itemName;

    @FindBy(className = "regular-price")
    WebElement regularPrice;

    @FindBy(xpath = "//p[@class='old-price']/span[@class='price']")
    WebElement oldPrice;

    @FindBy(xpath = "//p[@class='special-price']/span[@class='price']")
    WebElement specialPrice;

    @FindBy(className = "button btn-cart")
    WebElement addToCartButton;

    @FindBy(className = "link-wishlist")
    WebElement addToWishListButton;

    @FindBy(className = "link-compare")
    WebElement addToCompareButton;

    private String url = "http://live.demoguru99.com/index.php/mobile.html";

    public MobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getItemsList() {
        return itemsList;
    }

    public List<String> getItemNames() {
        List<String> itemNames = new ArrayList<>();
        for (WebElement item : itemsList) {
            itemNames.add(item.getText());
        }
        return itemNames;
    }

    public String getItemName() {
        return itemName.getText();
    }

    public boolean isSpecialPrice() {
        return driver.findElements(By.xpath("//div[@class='price-box']/p")).size() > 0;
    }

    public String getRegularPrice() {
        return regularPrice.getText();
    }

    public String getOldPrice() {
        return oldPrice.getText();
    }

    public String getSpecialPrice() {
        return specialPrice.getText();
    }

    public MobilePage open() {
        driver.get(url);
        return this;
    }

    public MobilePage refresh() {
        driver.navigate().refresh();
        return this;
    }

    public MobilePage sortBy() {
        Select selectForSort = new Select(driver.findElement(By.cssSelector("/select[title='Sort By']")));
        selectForSort.selectByVisibleText("Name");
        return this;
    }

    public MobilePage makeGridView() {
        viewAsGridMode.click();
        return this;
    }

    public MobilePage makeListView() {
        viewAsListMode.click();
        return this;
    }

    public MobilePage selectResultPerPage(String numItems) {
        selectResultPerPage = new Select(resultPerPageSelect);
        selectResultPerPage.selectByVisibleText(numItems);
        return this;
    }

    public CartPage addToCart() {
        addToCartButton.click();
        return new CartPage(driver);
    }

    public WishlistPage addToWishList() {
        addToWishListButton.click();
        return new WishlistPage(driver);
    }

    public MobilePage addToCompare() {
        addToCompareButton.click();
        return this;
    }

    public ItemInfoPage goToItemInfoPage() {
        itemName.click();
        return new ItemInfoPage(driver);
    }

}
