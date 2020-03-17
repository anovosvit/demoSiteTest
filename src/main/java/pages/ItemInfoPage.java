package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemInfoPage extends BasePage{
    @FindBy(xpath = "//*[@class=\"product-name\"]/span")
    WebElement itemName;

    @FindBy(xpath = "//span[@class='price']")
    WebElement itemPrice;

    @FindBy (xpath = "//*[@class='std']")
    WebElement itemDescription;

    public ItemInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public String getItemDescription() {
        return itemDescription.getText();
    }
}
