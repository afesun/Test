package base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.DriverContainer.getDriver;
import static org.testng.AssertJUnit.assertTrue;

public class PageBase {
    protected static void shouldAppear(String title) {
        WebDriverWait waiter = new WebDriverWait(getDriver(), 15);
        waiter.until(ExpectedConditions.titleIs(title));
        assertTrue("Title is incorrect. Actual: " + getDriver().getTitle()
                + ", expected: " + title, getDriver().getTitle().contains(title));
    }

}
