@TC10
Feature: 10. user status feature

  Scenario: verify user status

    Given User is on Library login "qa2-url" page
    And User login as a "librarian"
    When User is on "Users" module
    And User clicks "Status" dropdown
    Then User should see the following dropdown options on "Status" dropDown:
      | ACTIVE   |
      | INACTIVE |