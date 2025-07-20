package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    protected By acceptCookiesTerm = By.cssSelector("button[aria-label='Consent'] p[class='fc-button-label']");
    protected String categoryMenuXpath = "//a[text()='%s']";
    protected String categorySubmenuXpath = "//a[text()='%s']";


    public void acceptCookiesTerm() {
        waitForTheButtonToBeClickable(acceptCookiesTerm);
    }

    public void termWereAccepted() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(acceptCookiesTerm));
    }

    public void navigateToBagsCategory(String menuName, String submenuName) {
        By categoryMenuName = By.xpath(String.format(categoryMenuXpath, menuName));
        WebElement categoryMenu = waitForVisibility(categoryMenuName);

        Actions actions = new Actions(driver);
        actions.moveToElement(categoryMenu).pause(Duration.ofMillis(300)).perform();

        By categorySubMenuName = By.xpath(String.format(categorySubmenuXpath, submenuName));
        WebElement categorySubMenu = waitForVisibility(categorySubMenuName);

        categorySubMenu.click();
    }
}
