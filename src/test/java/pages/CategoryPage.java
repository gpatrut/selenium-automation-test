package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CategoryPage extends BasePage {

    protected String productTileXPath = "//a[normalize-space(text())='%s']/ancestor::li";
    protected String addToCartCategoryButton = "//a[normalize-space(text())='%s']/ancestor::li//button[@title='Add to Cart']";

    public void mouseOverProduct(String productName) {
        removeAds();

        WebElement productTile = waitForVisibility(By.xpath(String.format(productTileXPath, productName)));

        new Actions(driver)
                .moveToElement(productTile)
                .pause(Duration.ofMillis(500))
                .perform();
    }

    public void addProductToCart(String productName) {
        By addToCartButton = By.xpath(String.format(addToCartCategoryButton, productName));
        waitForVisibility(addToCartButton).click();
    }
}
