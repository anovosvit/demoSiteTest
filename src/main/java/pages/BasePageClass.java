package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageClass {
    WebDriver driver;
    WebDriverWait wait;
    String url;

    public BasePageClass(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public BasePageClass open() {
        driver.get(url);
        return this;
    }

}
