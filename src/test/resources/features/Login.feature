Feature: Login

@apple
  Scenario Outline: Valid login
    
    Given The user is on Open Browser and Enter URL
    When The user enters "<username>" and "<password>"
    And The user clicks on the login button
    Then The user is redirected to the homepage

    Examples: 
      | username | password |
      | user1    | pass1    |
	   #   | user2    | pass2    |
