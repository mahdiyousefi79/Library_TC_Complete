@TC03
Feature: 3. As a user, I should be able to  see several modules once I login.

  Background: User is already on Library login page
    Given User is on Library login "qa2-url" page

  @student
  Scenario Outline: Students should have access to 2 modules
    Given User login with credentials "<user name>" and "<password>":
    Then User should see following modules:
      | Books           |
      | Borrowing Books |
    Examples: user name and passwords examples:
      | user name         | password |
      | student30@library | IaT9YI0I |
      | student42@library| zCm83mcJ |
      | student56@library | 4dJYzMiG |

  @librarian
  Scenario Outline: Librarians  should have access to 3 modules
    Given User login with credentials "<user name>" and "<password>":
    Then User should see following modules:
      | Dashboard |
      | Users     |
      | Books     |
    Examples: user name and passwords examples:
      | user name           | password |
      | librarian50@library | kAbC7Ybl |
      | librarian17@library | tXqOoIOS |
      | librarian14@library | 87x8afWY |