package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.CommonPage;

public class ThankYouSteps {
    CommonPage commonPage = new CommonPage();

    @Given("the title of the page is {string}")
    public void theUserIsOnPageWithName(String expectedTitle) {
        commonPage.checkH1PageTitle(expectedTitle);
    }
}
