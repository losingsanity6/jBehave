package stepdefs;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.steps.Steps;

import static utils.DriverInIt.closeWebBrowser;
import static utils.DriverInIt.getDriver;

public class Hooks extends Steps {
    @BeforeScenario
    public void beforeScenario() {
        getDriver();
    }

    @AfterScenario
    public void afterScenario() {
        closeWebBrowser();
    }
}
