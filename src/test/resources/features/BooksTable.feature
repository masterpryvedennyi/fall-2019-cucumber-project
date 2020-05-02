Feature: books table

  Scenario: Verify search functionality
    Given I am on the login page
    And I login to application as a librarian
    When I navigate to "Books" page
    When I search for "The Goldfinch"
    Then search table should contain results matching The Goldfinch

  @wip
  Scenario: Verify book information
    Given I am on the login page
    And I login to application as a librarian
    And I navigate to "Books" page
    When I edit book The kite runner
    Then I verify book information
      | name            | author          | year |
      | The kite runner | Khaled Hosseini | 2003 |

    @wip
    Scenario: