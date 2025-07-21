package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.CartPage;

import java.util.Map;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @Given("the value in the mini-cart was updated at {int}")
    public void theValueInTheMiniCartWasUpdatedWth(Integer value) {
        cartPage.checkCartIconCounter(value);
    }

    @Given("user click on Proceed to checkout button")
    @Given("user click on Proceed to checkout mini cart button")
    public void userClickOnProceedToCheckoutButton() {
        cartPage.checkOutButton();
    }

    @Given("user clicks on cart icon")
    public void userClicksOnCartIcon() {
        cartPage.clickCartIcon();
    }

    @Given("user navigates to cart")
    public void userNavigatesToCart() {
        cartPage.clickCartIcon();
        cartPage.clickViewAndEditCart();
    }

    @Given("the message in the mini cart is {string}")
    public void theMessageInTheMiniCartIs(String message) {
        cartPage.emptyMiniCartMessage(message);
    }

    @Given("user update the qty the card with value {string}")
    public void userUpdateTheQtyTheCardWithValue(String qty) {
        cartPage.addQtyAndUpdateTheCart(qty);
    }

    @Given("check the order summary on cart page")
    public void verifyOrderSummary(DataTable dataTable) {
        Map<String, String> expectedValues = dataTable.asMap(String.class, String.class);
        cartPage.verifyOrderSummaryOnCart(expectedValues);
    }

    @Given("user delete the product from cart")
    public void userDeleteProductFromCart() {
        cartPage.clickDeleteButtonForProduct();
    }

    @Given("the empty cart message should be {string}")
    public void verifyEmptyCartMessage(String expectedMessage) {
        String actualMessage = cartPage.getEmptyCartMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected page title to contain '" + expectedMessage + "', but was '" + actualMessage + "'");

    }

    @Given("the product {string} should be visible in the cart")
    public void productShouldBeVisibleInCart(String expectedProductName) {
        cartPage.verifyProductInCart(expectedProductName);
    }

}
