Feature: Login Feature Multiple attempts

  Scenario: Multiple login attempts
    Given the user is on the login page
    When the user enters the following credentials
      | username    | password   |
      | user1       | pass1      |
      | user2       | pass2      |
      | user3       | pass3      |
    Then the login should be successful
