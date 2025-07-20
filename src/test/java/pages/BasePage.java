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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));

        try {
            removeAds();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
            el.click();
        } catch (ElementClickInterceptedException e) {
            removeAds();
            el = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
            el.click();
        }
    }

    protected void removeAds() {
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe[id^=\"aswift\"], iframe[src*=\"doubleclick\"], iframe[src*=\"googleads\"], iframe[title=\"Advertisement\"]').forEach(el => el.remove());"
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
