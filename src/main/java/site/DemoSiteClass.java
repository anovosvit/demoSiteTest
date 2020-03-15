package site;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePageClass;
import pages.MobilePageClass;

public class DemoSiteClass {
    private WebDriver driver;
    private HomePageClass homePage;
    private MobilePageClass mobilePage;

    public DemoSiteClass() {
        this.driver = new ChromeDriver();
        this.homePage = new HomePageClass(driver);
        this.mobilePage = new MobilePageClass(driver);
    }

    public HomePageClass getHomePage() {
        return homePage;
    }

    public MobilePageClass getMobilePage() {
        return mobilePage;
    }

    public HomePageClass openHomePage() {
        return homePage.open();
    }

    public MobilePageClass openMobilePage() {
        return mobilePage.open();
    }


    public void quit() {
        driver.quit();
    }
}
