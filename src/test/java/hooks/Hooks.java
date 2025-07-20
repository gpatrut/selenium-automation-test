package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BrowserFactory;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        boolean isMobile = scenario.getSourceTagNames().contains("@mobile");

        if (isMobile) {
            DriverManager.setDriver(BrowserFactory.setMobileDriver("Samsung Galaxy S20 Ultra"));
        } else {
            DriverManager.setDriver(BrowserFactory.setUpDriver());
        }
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
