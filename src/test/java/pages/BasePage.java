package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void closeAdsIfExistsAndClick(By locator) {
        try {
            removeAds();

            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
            el.click();
        } catch (ElementClickInterceptedException | TimeoutException e) {
            System.out.println("Retry after removing ad overlays...");

            removeAds();

            WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el); // JS fallback
        }
    }


    protected void removeAds() {
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll(" +
                        "'iframe[id^=\"aswift\"], " +
                        "iframe[src*=\"doubleclick\"], " +
                        "iframe[src*=\"googleads\"], " +
                        "iframe[title=\"Advertisement\"], " +
                        "div[id^=\"aswift\"], " +
                        "div[id*=\"google\"]'" +
                        ").forEach(el => el.remove());"
        );
    }

    protected void waitForTheButtonToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForLoaderToDisappear(By loaderLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
    }

}
