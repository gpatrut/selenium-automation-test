package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pages.CommonPage;
import pages.ShippingPage;

import java.util.Map;

public class ShippingSteps {
    ShippingPage shippingPage = new ShippingPage();
    CommonPage commonPage = new CommonPage();

    @Given("fills out the information for the shipping address")
    public void fillShippingAddress(DataTable dataTable) {
        Map<String, String> address = dataTable.asMaps(String.class, String.class).get(0); // ✅

        shippingPage.fillShippingForm(address);
        shippingPage.selectTheShippingMethod(address.get("shippingMethod"));
    }

    @Given("user clicks on {string} button")
    public void clickNextButton(String submitButton) {
        shippingPage.clickSubmitButton(submitButton);
    }

    @Given("the page title is {string}")
    public void thePageTitleIs(String expectedTitle) {
        commonPage.pageTitle(expectedTitle);
    }
}
