package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pages.PaymentPage;

import java.util.List;
import java.util.Map;

public class PaymentSteps {
    PaymentPage paymentPage = new PaymentPage();

    @Given("check the address summary on checkout page")
    public void verifyAddressSummary(DataTable dataTable) {
        List<String> expectedLines = dataTable.asList();
        paymentPage.verifyAddressSummary(expectedLines);
    }
    @Given("check the order summary on checkout page")
    public void verifyOrderSummary(DataTable dataTable) {
        Map<String, String> expectedValues = dataTable.asMap(String.class, String.class);
        paymentPage.verifyOrderSummary(expectedValues);
    }

    @Given("the estimated total value is {string}")
    public void theEstimatedTotalValueIs(String expectedValue) {
        paymentPage.verifyEstimatedTotalValue(expectedValue);
    }

}
