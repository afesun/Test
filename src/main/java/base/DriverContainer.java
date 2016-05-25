package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverContainer {
    public enum Driver {
        Firefox,
        Chrome,
        IE,
        HtmlUnit
    }

    private static Driver driverType;
    private static WebDriver driver = null;

    private DriverContainer() {
        //block constructor for outer calls
    }

    public static void setDriver(Driver driverType) {
        DriverContainer.driverType = driverType;
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            switch (driverType) {
                case Firefox:
                    driver = new FirefoxDriver();
                    break;
                case Chrome:
                    driver = new ChromeDriver();
                    break;
                case IE:
                    driver = new InternetExplorerDriver();
                    break;
                case HtmlUnit:
                    driver = new HtmlUnitDriver();
                    ((HtmlUnitDriver)driver).setJavascriptEnabled(true);
                    break;
                default:
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        return driver;
    }

    public static WebElement findElement(By locator) {
        return getDriver().findElement(locator);
    }

    public static void open(String url) {
        getDriver().get(url);
    }

    public static void quit() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}