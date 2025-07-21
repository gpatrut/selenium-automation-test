package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class CartPage extends BasePage {

    protected By checkCartIconCounter = By.cssSelector("span.counter-number");
    protected By clickCartIcon = By.cssSelector("a.action.showcart");
    protected By clickViewAndEditCart = By.cssSelector("a.action.viewcart");
    protected By checkOutButton = By.cssSelector("button[title='Proceed to Checkout']");
    protected By emptyMiniCartMessage = By.cssSelector("#minicart-content-wrapper strong.subtitle.empty");
    protected By updateCartButton = By.cssSelector("button[title='Update Shopping Cart'] span");
    protected By cartQuantityInput = By.cssSelector("input[title='Qty']");
    protected By deleteButtonLocator = By.cssSelector("a.action-delete[title='Remove item']");
    protected By emptyCartMsgLocator = By.xpath("//div[@class='cart-empty']/p[1]");
    protected By productsNameLocator = By.xpath("//strong[@class='product-item-name']/a");

    public void checkCartIconCounter(Integer expectedCounterValue) {
        Integer actualCounterValue = Integer.valueOf(driver.findElement(checkCartIconCounter).getText().trim());
        Assert.assertEquals(actualCounterValue, expectedCounterValue, "Actual value is " + actualCounterValue + "and expected value is " + expectedCounterValue);
    }

    public void checkOutButton() {
        closeAdsIfExistsAndClick(checkOutButton);
    }

    public void clickCartIcon() {
        closeAdsIfExistsAndClick(clickCartIcon);
    }

    public void clickViewAndEditCart() {
        closeAdsIfExistsAndClick(clickViewAndEditCart);
    }

    public void emptyMiniCartMessage(String message) {
        WebElement element = waitForVisibility(emptyMiniCartMessage);
        String actualMessage = element.getText().trim();
        Assert.assertEquals(actualMessage, message, "Actual value is " + actualMessage + " and expected value is " + message);
    }

    public void addQuantityInCart(String quantity) {
        WebElement quantityField = driver.findElement(cartQuantityInput);
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void addQtyAndUpdateTheCart(String qty) {
        removeAds();
        addQuantityInCart(qty);
        waitForTheButtonToBeClickable(updateCartButton);
        waitForLoaderToDisappear(By.xpath("//div[@class='loading-mask']"));
    }

    public void verifyOrderSummaryOnCart(Map<String, String> expectedValues) {
        String cartSubtotal = driver.findElement(By.cssSelector("tr.totals.sub span.price")).getText().trim();
        String total = driver.findElement(By.cssSelector("tr.grand.totals span.price")).getText().trim();


        Assert.assertEquals(cartSubtotal, expectedValues.get("Cart Subtotal"), "Cart Subtotal mismatch");
        Assert.assertEquals(total, expectedValues.get("Order Total"), "Order Total mismatch");
    }

    public void clickDeleteButtonForProduct() {
        removeAds();
        waitForVisibility(deleteButtonLocator).click();
    }

    public String getEmptyCartMessage() {
        removeAds();
        String emptyCartMessage =  waitForVisibility(emptyCartMsgLocator).getText().trim();
        return emptyCartMessage.replaceAll("\\s{2,}", " ");
    }

    public void verifyProductInCart(String expectedProductName) {
        List<WebElement> productElements = driver.findElements(productsNameLocator);

        boolean productFound = productElements.stream()
                .anyMatch(el -> el.getText().trim().equalsIgnoreCase(expectedProductName));

        Assert.assertTrue(productFound, "Product '" + expectedProductName + "' was not found in the cart.");
    }
}
