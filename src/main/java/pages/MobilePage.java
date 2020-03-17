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
    @FindBy(css = "select[title=\"Sort By\"]")
    WebElement sortSelector;

    @FindBy(xpath = "//*[@title = 'Grid']")
    WebElement viewAsGridMode;

    @FindBy(xpath = "//*[@title = 'List']")
    WebElement viewAsListMode;

    @FindBy(xpath = "//*[@title = 'Results per page']")
    WebElement resultPerPageSelect;

    @FindBy(className = "item last")
    List<WebElement> itemsList;

    @FindBy(className = "regular-price")
    WebElement regularPrice;

    @FindBy(xpath = "//h2[@class='product-name']//a")
    WebElement itemName;

    @FindBy(xpath = "//p[@class='old-price']/span[@class='price']")
    WebElement oldPrice;

    @FindBy(xpath = "//p[@class='special-price']/span[@class='price']")
    WebElement specialPrice;

    @FindBy(xpath = "//*[@class='desc std']")
    WebElement itemDescription;

    @FindBy(className = "link-learn")
    WebElement aboutItemLink;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    WebElement addToCartButton;

    @FindBy(className = "link-wishlist")
    WebElement addToWishListButton;

    @FindBy(className = "link-compare")
    WebElement addToCompareButton;

    @FindBy(className = "success-msg")
    WebElement successCompareText;

    private String url = "http://live.demoguru99.com/index.php/mobile.html";

    public MobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getRegularPrice() {
        return regularPrice.getText();
    }

    public String getItemDescription() {
        return itemDescription.getText();
    }

    public String getSuccessCompareText() {
        return successCompareText.getText();
    }

    public ItemInfoPage clickLearnMore() {
        aboutItemLink.click();
        return new ItemInfoPage(driver);
    }

    public WishlistPage addToWishList() {
        addToWishListButton.click();
        return new WishlistPage(driver);
    }

    public MobilePage addToCompare() {
        addToCompareButton.click();
        return this;
    }

    public List<WebElement> getItemsList() {
        return itemsList;
    }

    public boolean isSpecialPrice() {
        return driver.findElements(By.xpath("//div[@class='price-box']/p")).size() > 0;
    }

    public MobilePage open() {
        driver.get(url);
        return this;
    }

    public MobilePage sortBy(String sortName) {
        new Select(sortSelector).selectByVisibleText(sortName);
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
        new Select(resultPerPageSelect).selectByVisibleText(numItems);
        return this;
    }

    public CartPage addToCart() {
        addToCartButton.click();
        return new CartPage(driver);
    }

    public List<String> getItemNames() {
        List<String> itemNames = new ArrayList<>();
        for (WebElement item : itemsList) {
            itemNames.add(item.getText());
        }
        return itemNames;
    }

    public List<String> getPriceList() {
        List<String> priceList = new ArrayList<>();
        //TODO: Сделать список цен
        return priceList;
    }
}
