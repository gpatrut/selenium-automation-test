package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.RegisterUserPage;

public class RegisterUserSteps {
    RegisterUserPage registerUserPage = new  RegisterUserPage();

    @Given("user creates an account with first name {string}, last name {string} and password {string}")
    public void createAccount(String firstName, String lastName, String password) {
        registerUserPage.createNewAccount(firstName, lastName, password);
    }
}
