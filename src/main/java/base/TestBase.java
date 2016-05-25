package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static base.DriverContainer.*;

public class TestBase {
    protected static final String BASE_URL = "https://ops.post.adamantium.net/login";
    @BeforeTest
    public void setup() {
        setDriver(Driver.HtmlUnit);
        open(BASE_URL);
    }

    @BeforeClass
    public void login() {
        //LoginPage.shouldAppear();
       // LoginPage.login();
       // MailPage.shouldAppear();
    }

    @AfterClass
    public void logout() {
      //  Header.logout();
    }

    @AfterTest
    public void tearDown() {
        quit();
    }
}
