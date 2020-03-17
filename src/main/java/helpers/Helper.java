package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
    WebDriver driver;

    public static void waitElement(WebDriver driver, By elementBy) {
        (new WebDriverWait(driver, 15)).until((driver1 -> driver1.findElement(elementBy)));
    }
}
