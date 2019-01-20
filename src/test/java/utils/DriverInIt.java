package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInIt {

        public static WebDriver driver;
        private static String driverType = ConstantVariables.browser;

        public DriverInIt() {
        }

        public static WebDriver getDriver() {

            if (driverType != null) {
                if (driverType.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", ConstantVariables.driverPathChrome);
                    driver = new ChromeDriver();
                } else if (driverType.equals("ff")) {
                    System.setProperty("webdriver.gecko.driver", ConstantVariables.driverPathFirefox);
                    driver = new FirefoxDriver();
                }
            }
            return driver;
        }

        public static void closeWebBrowser() {
            if (driver != null) {
                driver.quit();
            }
            driver = null;
        }

        public static void openPage(String url) {
            driver.get(url);
        }

    }

