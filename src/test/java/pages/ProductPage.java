package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class ProductPage extends BasePage {

    protected String productSizeLocator = "div.swatch-option.text[aria-label='%s']";
    protected String productColorLocator = "div.swatch-option.color[aria-label='%s']";
    protected String productPageLocator = "//a[@class='product-item-link' and normalize-space(text())='%s']";
    protected By qtyField = By.id("qty");
    protected By qtyErrorField = By.id("qty-error");
    protected By productTitleField = By.cssSelector("h1.page-title");
    protected By addToCartButton = By.id("product-addtocart-button");


    public void openTheProductPage(String productName) {
        By productPage = By.xpath(String.format(productPageLocator, productName));
        driver.findElement(productPage).click();
    }

    public void checkProductPageIsOpened() {
        WebElement pageTitle = waitForVisibility(productTitleField);
        Assert.assertTrue(pageTitle.isDisplayed());
    }

    public void selectProductSize(String size) {
        By productSize = By.cssSelector(String.format(productSizeLocator, size));
        closeAdsIfExistsAndClick(productSize);
    }

    public void selectProductColor(String color) {
        By productColor = By.cssSelector(String.format(productColorLocator, color));
        closeAdsIfExistsAndClick(productColor);
    }

    public void enterProductQuantity(String qty) {
        removeAds();
        WebElement quantity = driver.findElement(qtyField);
        quantity.clear();
        quantity.sendKeys(qty);
    }

    public void checkProductNameTitle(String productName) {
        String title = driver.findElement(productTitleField).getText().trim();
        Assert.assertEquals(title, productName, "Product name does not match!");
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void getErrorForQuantity(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(qtyErrorField).getText().trim();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match!");
    }
}
