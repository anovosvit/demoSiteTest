package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    @FindBy(tagName = "h1")
    WebElement pageInfo;

    @FindBy(id = "shopping-cart-table")
    WebElement orderTable;

    @FindBy(xpath = "//h2[@class='product-name']")
    WebElement itemName;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageInfo() {
        return pageInfo.getText();
    }

    public boolean isOnThisPage() {
        return driver.findElements(By.xpath("//*[@id='nav']//a")).size() > 0;
    }

}
