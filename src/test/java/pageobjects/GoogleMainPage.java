package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.DriverInIt.driver;

public class GoogleMainPage {
    public static final String SEARCH_INPUT = "q";
    public static final String SEARCH_BUTTON = "//div[@class='FPdoLc VlcLAe']//input[@name='btnK']";
    public static final String GOOGLE_LOGO = "hplogo";

    public void sendKeysToInput(String searchText) {
        driver.findElement(searchInput()).sendKeys(searchText);
    }

    public void clickButton() {
        driver.findElement(submitButton()).click();

    }

    public void clickReturn() {
        driver.findElement(searchInput()).sendKeys(Keys.RETURN);
    }

    public void clickGoogleLogo() {
        driver.findElement(googleLogo()).click();
    }

    private By searchInput() {
        return By.name(SEARCH_INPUT);
    }

    private By submitButton() {
        return By.xpath(SEARCH_BUTTON);
    }

    private By googleLogo() {
        return By.id(GOOGLE_LOGO);
    }
}
