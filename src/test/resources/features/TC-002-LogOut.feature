@TC02
Feature: 2. As a user, I should be able to logout from the library app.

  Scenario Outline: User is able to log out
    Given User is on Library login "qa2-url" page
    Given User login as a "<role>"
    When User loges out from app
    Then User is on Login page
    Examples:
      | role      |
      | student   |
      | librarian |




 # we use scenario out line because we want to run the same test ("Given User login as a "<role>"), against different test data
  # role and page has 2 different date


