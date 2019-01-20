package stepdefs;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import pageobjects.GoogleMainPage;
import pageobjects.SearchResultsPage;
import utils.ConstantVariables;

import static utils.DriverInIt.*;

public class GoogleSteps extends Steps {

    @Given("User is on Google page")
    public void userIsOnGoolgePage() {
        openPage(ConstantVariables.URL);
    }

    @When("User enters '$seatchText' into searchbox")
    public void whenUserEntersSearchText(String searchText) {
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.sendKeysToInput(searchText);
    }

    @When("User click search Button")
    public void whenUserClicksSearchButton() {
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.clickButton();

    }

    @When("User click Google logo")
    public void whenUserClicksGoogleLogo() {
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.clickGoogleLogo();

    }

    @Then("User see '$searchText' in '$linkNumber' link")
    public void ThenUserSeeFirstLinkContainsSearchWord(String searchText, String linkNumber) {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        String linkText = searchResultsPage.getText(linkNumber).toLowerCase();
        Assert.assertTrue(linkText.contains(searchText.toLowerCase()));
    }

}
