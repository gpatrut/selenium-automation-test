package pages;

import org.openqa.selenium.By;

import java.util.UUID;

public class RegisterUserPage extends BasePage {

    private String generateRandomEmail() {
        String uuid = UUID.randomUUID().toString().substring(0, 6);
        return "test" + uuid + "@email.com";
    }

    public void createNewAccount(String firstName, String lastName, String password) {
        String generateEmail = generateRandomEmail();

        waitForVisibility(By.id("firstname")).sendKeys(firstName);
        waitForVisibility(By.id("lastname")).sendKeys(lastName);
        waitForVisibility(By.id("email_address")).sendKeys(generateEmail);
        waitForVisibility(By.id("password")).sendKeys(password);
        waitForVisibility(By.id("password-confirmation")).sendKeys(password);

        closeAdsIfExistsAndClick(By.cssSelector("button[title='Create an Account']"));
        System.out.println("Account created with email: " + generateEmail);
    }
}
