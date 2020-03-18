package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage{
    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    String url = "http://live.demoguru99.com/index.php/customer/account/create/";

    @FindBy(tagName = "h1")
    WebElement pageInfo;

    public String getPageInfo() {
        return pageInfo.getText();
    }

    public CreateAccountPage open() {
        driver.get(url);
        return this;
    }
}
