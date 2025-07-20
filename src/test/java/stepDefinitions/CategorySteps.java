package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.CategoryPage;

public class CategorySteps {
    CategoryPage categoryPage = new  CategoryPage();

    @Given("user add the product {string} into the cart")
    public void userAddTheProductIntoTheCart(String productName) {
        categoryPage.mouseOverProduct(productName);
        categoryPage.addProductToCart(productName);
    }
}
