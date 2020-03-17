package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ItemInfoPage extends BasePage{
    public ItemInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
