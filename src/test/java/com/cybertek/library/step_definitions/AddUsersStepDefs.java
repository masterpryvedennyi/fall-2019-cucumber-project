package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AddUsersStepDefs {
    UsersPage usersPage = new UsersPage();

    @When("I click on Add Users")
    public void i_click_on_Add_Users() {
        usersPage.addUser.click();
    }

    @Then("dialog fields must have matching placeholders")
    public void dialog_fields_must_have_matching_placeholders(Map<String, String> fields) {
        for (String key : fields.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value = " + fields.get(key));
            System.out.println();
        }
        String expectedFullName = fields.get("fullname");
        String actualFullName = usersPage.fullName.getAttribute("placeholder");
        assertEquals("Full Name placeholder assertion failed", expectedFullName, actualFullName);

        String expectedEmail = fields.get("email");
        String actualEmail = usersPage.email.getAttribute("placeholder");
        assertEquals("Email placeholder assertion failed", expectedEmail, actualEmail);

        String expectedPassword = fields.get("password");
        String actualPassword = usersPage.password.getAttribute("placeholder");
        assertEquals("Password placeholder assertion failed" , expectedPassword, actualPassword);
    }
}
