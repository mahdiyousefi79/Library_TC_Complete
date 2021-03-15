@TC01
Feature: 1. As a user, I should be able to login to the library app.


  Scenario Outline: verify both Students and librarians  login
    Given User is on Library login "qa2-url" page
    And User login as a "<role>"
    Then User is on "<page>" page
    Examples:
      | role      | page       |
      | student   | #books     |
      | librarian | #dashboard |


# we use scenario out line because we want to run the same test, against different test data
  # role and page has 2 different date