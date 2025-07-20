package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class ShippingPage extends BasePage {

    protected String shippingMethod = "//tr[.//td[contains(text(), '%s')]]//input[@type='radio']";
    protected String submitButtonXpath = "//span[normalize-space()='%s']";

    public void fillShippingForm(Map<String, String> address) {
        removeAds();
        if (address.containsKey("email")) {
            waitForVisibility(By.id("customer-email")).sendKeys(address.get("email"));
        }
        if (address.containsKey("first name")) {
            waitForVisibility(By.name("firstname")).sendKeys(address.get("first name"));
        }
        if (address.containsKey("last name")) {
            waitForVisibility(By.name("lastname")).sendKeys(address.get("last name"));
        }
        waitForVisibility(By.name("street[0]")).sendKeys(address.get("street address"));
        waitForVisibility(By.name("city")).sendKeys(address.get("city"));

        By regionField = By.name("region_id");
        closeAdsIfExistsAndClick(regionField);

        clickOptionByDataTitle(address.get("state"));
        waitForVisibility(By.name("postcode")).sendKeys(address.get("zipcode"));
        waitForVisibility(By.name("telephone")).sendKeys(address.get("phone number"));
    }

    private void clickOptionByDataTitle(String dataTitleValue) {
        By optionLocator = By.cssSelector("select[name='region_id'] option[data-title='" + dataTitleValue + "']");

        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        option.click();
        System.out.println("Clicked option with data-title: " + dataTitleValue);
    }

    public void selectTheShippingMethod(String pickShippingMethod) {
        removeAds();
        By shippingMethodLocator = By.xpath(String.format(shippingMethod, pickShippingMethod));
        driver.findElement(shippingMethodLocator).click();
    }

    public void clickSubmitButton(String submitButton) {
        By submitButtonLocator = By.xpath(String.format(submitButtonXpath, submitButton));
        driver.findElement(submitButtonLocator).click();
    }
}
