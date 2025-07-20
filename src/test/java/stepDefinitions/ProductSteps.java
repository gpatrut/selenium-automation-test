package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.CommonPage;
import pages.ProductPage;

public class ProductSteps {

    ProductPage productPage = new ProductPage();
    CommonPage commonPage = new CommonPage();

    @Given("user opens the product page {string}")
    public void userOpensTheProductPage(String productName) {
        productPage.openTheProductPage(productName);
        productPage.checkProductPageIsOpened();
    }

    @Given("user selects size {string}, color {string} qty {string}")
    public void userSelectOptionsForTheProduct(String size, String color, String qty) {
        productPage.selectProductSize(size);
        productPage.selectProductColor(color);
        productPage.enterProductQuantity(qty);
    }

    @Given("user insert qty {string}")
    public void userAddsQtyForTheProduct(String qty) {
        productPage.enterProductQuantity(qty);
    }

    @Given("the product {string} page is opened")
    public void theProductPageIsOpened(String productName) {
        productPage.checkProductNameTitle(productName);
    }

    @Given("user click on Add to cart button")
    public void userClickOnAddToCartButton() {
        productPage.clickAddToCartButton();
    }

    @Given("user checks the successful message contains {string}")
    public void userChecksTheSuccessfulMessageContains(String message) {
        commonPage.checkSuccessMessage(message);
    }

    @Given("user checks the error message contains {string}")
    public void userChecksTheErrorMessageContains(String message) {
        commonPage.checkErrorMessage(message);
    }

    @Given("user gets the error {string} for qty")
        public void userGetsTheErrorForQty(String expectedErrorMessage) {
        productPage.getErrorForQuantity(expectedErrorMessage);

        }

}
