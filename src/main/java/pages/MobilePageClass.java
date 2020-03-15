package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MobilePageClass extends BasePageClass{
    private String url = "http://live.demoguru99.com/index.php/mobile.html";

    public MobilePageClass(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MobilePageClass open() {
        driver.get(url);
        return this;
    }

}
