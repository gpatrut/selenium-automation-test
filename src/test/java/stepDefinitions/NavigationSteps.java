package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.NavigationPage;

public class NavigationSteps {
    NavigationPage navigationPage = new NavigationPage();

    @Given("User opens the {string} page")
    public void UserOpensThePageWithUrl(String url) {
        navigationPage.goToUrl(url);
    }
}
