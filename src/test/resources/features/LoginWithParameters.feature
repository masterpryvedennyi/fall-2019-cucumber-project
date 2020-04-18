Feature: Login with parameters


  @wip
  Scenario: Login as librarian 11
    Given I am on the login page
    When I enter username "librarian11@library"
    And I enter password "I61FFPPf"
    And I click the sign in button
    Then dashboard page should be displayed

    @wip
    Scenario: Login as librarian 12
      Given I am on the login page
      When I enter password "librarian12@library"
      And I enter password "AOYKYTMJ"
      And I click the sign in button
      Then dashboard page should be displayed
      And there should be 23 users

      @wip
      Scenario: Login as librarian same line
        Given I am on the login page
        When I login using "librarian12@library" and "AOYKYTMJ"
        Then dashboard page should be displayed
        And there should be 23 'users'
