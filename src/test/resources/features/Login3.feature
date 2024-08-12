	# src/test/resources/features/Login.feature
	Feature: Login
	
	  Scenario: Valid login
	   Given The user is on Open Browser and Enter URL
	    When The user enters "<samp>" and "<pass>"
	    And The user clicks on the login button
	    Then The user is redirected to the homepage

