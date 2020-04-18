@smoke @lib-100 @login
Feature: Login
  As a user,
  I should be able to login to the application

  @librarian
  Scenario: Login as librarian
    Given I am on the login page
    When I login as a librarian user
    Then dashboard page should be displayed

  @student
  Scenario: Login as a student
    Given I am on the login page
    When I login as a student
    Then dashboard page should be displayed

  @admin
  Scenario: Login as an admin
    Given I am on the login page
    When I login as an admin
    Then dashboard page should be displayed