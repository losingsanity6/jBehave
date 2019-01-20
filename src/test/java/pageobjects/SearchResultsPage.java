package pageobjects;

import org.openqa.selenium.By;

import static utils.DriverInIt.driver;

public class SearchResultsPage {
    private static final String FIRST_LINK = "//div[@class='r']//a/h3[%s]";

    public String getText(String linkNumber) {
        return driver.findElement(Link(linkNumber)).getText();
    }

    private By Link(String linkNumber) {
        return By.xpath(String.format(FIRST_LINK, linkNumber));
    }
}
