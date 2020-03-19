package helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import site.DemoSite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

public class EventHandler extends AbstractWebDriverEventListener {
    DemoSite demoSite;

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println(new Date() + " BEFORE FIND BY: Should be " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println(new Date() + " AFTER FIND BY: " + webElement + " - Element found");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println(new Date() + " BEFORE CLICK ON: Should click " + webElement.getTagName());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println(new Date() + " AFTER CLICK ON: " + webElement + " - Clicked successfull");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println(new Date() + " EXCEPTION!!! " + throwable);
        File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screen = new File("./src/screens/screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tempFile.toPath(), screen.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
