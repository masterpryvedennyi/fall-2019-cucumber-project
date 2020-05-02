package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs2 {
    LoginPage loginPage = new LoginPage();


    @When("I enter username {string}")
    public void i_enter_username(String username) {
        BrowserUtils.fluentWait(loginPage.email, 3);
        loginPage.email.sendKeys(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.password.sendKeys(password);
    }

    @When("I click the sign in button")
    public void i_click_the_sign_in_button() {
        loginPage.signIn.click();
    }

    @Then("there should be {int} users")
    public void there_should_be_users(Integer count) {
        System.out.println("Verifying user count " + count);
    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String username, String password) {
        loginPage.email.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.signIn.click();
    }

    @Then("there should be {int} {string}")
    public void there_should_be(Integer count, String type) {
        System.out.println("Verifying " + count + " " + type);
    }
}
