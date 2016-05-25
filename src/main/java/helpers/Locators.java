package helpers;

import org.openqa.selenium.By;

import java.io.InputStream;
import java.util.Properties;

    public class Locators {
        private static Properties locators;

        private enum LocatorType {
            id,
            name,
            className,
            tagName,
            linkText,
            css,
            xpath
        }

        static {
            locators = new Properties();
            InputStream is = Locators.class.getResourceAsStream("/locators.properties");
            try {
                locators.load(is);
            } catch (Exception e) {
                System.out.println("Error reading from property file");
            }
        }

        public static By getLocator(String locator) {
            String value = locators.getProperty(locator);

            String[] result = value.split("=", 2);
            LocatorType locatorType = LocatorType.valueOf(result[0]);
            String selector = result[1];
            switch (locatorType) {
                case id:
                    return By.id(selector);

                case name:
                    return By.name(selector);

                case css:
                    return By.cssSelector(selector);

                case xpath:
                    return By.xpath(selector);

                default:
                    throw new IllegalArgumentException("No such locator type");
            }
        }
    }

