package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PaymentPage extends BasePage {

    public void verifyAddressSummary(List<String> expectedLines) {
        WebElement addressBlock = waitForVisibility(By.cssSelector(".checkout-billing-address .billing-address-details"));
        String fullAddressText = addressBlock.getText().trim();

        List<String> actualLines = Stream.of(fullAddressText.split("\n"))
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .collect(Collectors.toList());
        System.out.println("Actual Address Lines:");
        actualLines.forEach(System.out::println);

        Assert.assertEquals(actualLines, expectedLines,
                "Displayed address summary " + actualLines + " does not match expected lines." + expectedLines);
    }

    public void verifyOrderSummary(Map<String, String> expectedValues) {
        String cartSubtotal = driver.findElement(By.cssSelector("tr.totals.sub span.price")).getText().trim();
        String shipping = driver.findElement(By.cssSelector("tr.totals.shipping span.price")).getText().trim();
        String shippingMethod = driver.findElement(By.cssSelector("tr.totals.shipping .value")).getText().trim();
        String total = driver.findElement(By.cssSelector("tr.grand.totals span.price")).getText().trim();

        Assert.assertEquals(cartSubtotal, expectedValues.get("Cart Subtotal"), "Cart Subtotal mismatch");
        Assert.assertEquals(shipping, expectedValues.get("Shipping"), "Shipping amount mismatch");
        Assert.assertEquals(shippingMethod, expectedValues.get("Shipping Method"), "Shipping Method mismatch");
        Assert.assertEquals(total, expectedValues.get("Order Total"), "Order Total mismatch");
    }

    public void verifyEstimatedTotalValue (String expectedValue) {
        String estimatedTotalValue = driver.findElement(By.cssSelector("span.estimated-price")).getText();
        Assert.assertEquals(estimatedTotalValue, expectedValue, "Expected value is " + expectedValue + " and actual value is " + estimatedTotalValue);
    }
}
