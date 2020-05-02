package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import com.cybertek.library.utilities.LibraryConstants;
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

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        String email = ConfigurationReader.getProperty("librarian_email");
        String password = ConfigurationReader.getProperty("librarian_password");
        loginPage.login(email, password);

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
        String email = ConfigurationReader.getProperty("student_email");
        String password = ConfigurationReader.getProperty("student_password");
        loginPage.login(email, password);
    }

    @When("I login as an admin")
    public void i_login_as_an_admin() {
        String email = ConfigurationReader.getProperty("admin_email");
        String password = ConfigurationReader.getProperty("admin_password");
        loginPage.login(email, password);
    }

    @Given("I login using following credentials:")
    public void i_login_using_following_credentials(Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        loginPage.login(email, password);
    }

    @Given("I login to application as a {word}")
    public void i_login_to_application_as_a_(String user) throws Exception {
        String email = null, password = null;

        switch (user.toLowerCase()){
            case LibraryConstants.LIBRARIAN:
                email = ConfigurationReader.getProperty("librarian_email");
                password = ConfigurationReader.getProperty("librarian_password");
                break;
            case LibraryConstants.STUDENT:
                email = ConfigurationReader.getProperty("student_email");
                password = ConfigurationReader.getProperty("student_password");
                break;
            default:
//                Assert.fail("Wrong user type is provided: " + user);
                throw new Exception("Wrong user type is provided: " + user);
        }
        loginPage.login(email, password);
    }



}
