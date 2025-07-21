package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonPage extends BasePage {
    protected String pageTitleXpath = "//div[@class='step-title' and contains(text(), \"%s\")]";
    protected String h1TitlePage = "//h1[@class='page-title']/span[contains(text(), \"%s\")]";
    protected By successMessageLocator = By.xpath("//div[@data-ui-id='message-success']");
    protected By errorMessageLocator = By.xpath("//div[@data-ui-id='message-error']");
    protected By searchBarLocator = By.cssSelector("input#search");


    public void pageTitle(String expectedTitle) {
        By extractPageTitle = By.xpath(String.format(pageTitleXpath, expectedTitle));
        WebElement titleElement = waitForVisibility(extractPageTitle);
        String actualTitle = titleElement.getText().trim();

        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Expected page title to contain '" + expectedTitle + "', but was '" + actualTitle + "'");
    }

    public void checkH1PageTitle(String expectedTitle) {
        By pageTitleLocator = By.xpath(String.format(h1TitlePage, expectedTitle));
        removeAds();
        WebElement element = waitForVisibility(pageTitleLocator);
        String actualTitle = element.getText().trim();

        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Expected page title to contain '" + expectedTitle + "', but was '" + actualTitle + "'");

    }
    public void checkSuccessMessage(String message) {
        WebElement messageElement = waitForVisibility(successMessageLocator);
        String extractedMessage = messageElement.getText().trim();
        Assert.assertTrue(extractedMessage.contains(message), "Message does not match!");
    }

    public void checkErrorMessage(String message) {
        WebElement messageElement = waitForVisibility(errorMessageLocator);
        String extractedMessage = messageElement.getText().trim();
        Assert.assertTrue(extractedMessage.contains(message), "Message does not match!");
    }

    public void fillAndSearchForAProduct(String expectedTitle) {
        WebElement searchBarElement = waitForVisibility(searchBarLocator);
        searchBarElement.clear();
        searchBarElement.sendKeys(expectedTitle);
        searchBarElement.submit();
    }
}