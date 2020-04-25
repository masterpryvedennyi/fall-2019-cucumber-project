package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PageNavigationStepDefs {
    DashboardPage dashBoardPage = new DashboardPage();
    UsersPage usersPage = new UsersPage();

    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        switch (link.toLowerCase()) {
            case "dashboard":
                dashBoardPage.dashboard.click();
                break;
            case "users":
                dashBoardPage.users.click();
                break;
            case "books":
                dashBoardPage.books.click();
                break;
        }
    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String page) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith(page.toLowerCase()));
        BrowserUtils.wait(1);
        switch (page.toLowerCase()) {
            case "users":
                String actual = dashBoardPage.pageHeader.getText();
                Assert.assertEquals("User Management", actual);
                break;
            case "books":
                actual = dashBoardPage.pageHeader.getText();
                Assert.assertEquals("Book Management", actual);
                break;
        }
    }


    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer selected) {
        System.out.println("selected = " + selected);
        UsersPage usersPage = new UsersPage();
        String actual = usersPage.getShowRecords().getFirstSelectedOption().getText();
        Assert.assertEquals(selected+"", actual);

    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        System.out.println("options.size() = " + options.size());
        System.out.println(options);
    }

    @When("I select Show {int} records")
    public void i_select_Show_records(Integer option) {
        usersPage.getShowRecords().selectByVisibleText(option.toString());
    }

    @Then("the users table must display {int} records")
    public void the_users_table_must_display_records(int expectedCount) {
        BrowserUtils.wait(1);
        int actualCount = usersPage.allRows.size();
        Assert.assertEquals(expectedCount, actualCount);

    }

}