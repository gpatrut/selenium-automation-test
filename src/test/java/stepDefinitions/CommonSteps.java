package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.CommonPage;

public class CommonSteps {
    CommonPage commonPage = new CommonPage();

    @Given("the title of the page contains {string}")
    public void theUserIsOnPageThatContainsWithName(String expectedTitle) {
        commonPage.checkH1PageTitle(expectedTitle);
    }

    @Given("user use the search bar to search for {string} product")
    public void theUserUseTheSearchBarToSearchForProduct(String expectedTitle) {
        commonPage.fillAndSearchForAProduct(expectedTitle);
    }
}
