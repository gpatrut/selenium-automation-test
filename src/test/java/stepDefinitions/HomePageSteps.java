package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.HomePage;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    @Given("user accepts cookies terms")
    public void userAcceptCookiesTerm() {
        homePage.acceptCookiesTerm();
        homePage.termWereAccepted();
    }

    @Given("user navigates to the {string} menu and {string} category")
    public void userNavigatesToBagsCategory(String menu, String submenu) {
        homePage.navigateToBagsCategory(menu, submenu);
    }
}
