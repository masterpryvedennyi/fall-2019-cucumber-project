package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;


public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.out.println("Going to the login page");
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    @When("I login as a librarian user")
    public void i_login_as_a_librarian_user() {
        System.out.println("Logging in as librarian");
        String email = ConfigurationReader.getProperty("librarian_email");
        String password = ConfigurationReader.getProperty("librarian_password");
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);
        loginPage.signIn.click();

    }
    @Then("dashboard page should be displayed")
    public void dashboard_page_should_be_displayed() {
        System.out.println("Verifying dashboard page is displayed");
        wait.until(ExpectedConditions.urlContains("dashboard"));
        String actualTitle = Driver.getDriver().getCurrentUrl();
       // BrowserUtils.waitForPageToLoad(3);
        Assert.assertTrue(actualTitle.endsWith("dashboard"));
    }

    @When("I login as a student")
    public void i_login_as_a_student() {
        System.out.println("Logging in as a student");
    }

    @When("I login as an admin")
    public void i_login_as_an_admin() {
        System.out.println("Logging in as an admin");
    }

    @Given("I login using following credentials:")
    public void i_login_using_following_credentials(Map<String, String> credentials) {
        System.out.println(credentials);
        String email = credentials.get("email");
        String password = credentials.get("password");
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        loginPage.login(email, password);
    }
}
