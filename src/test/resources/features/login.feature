Feature: Login to sauceDemo




  @Login
  Scenario: Login to sauceDemo and verify you are logged in
    Given user is on login page
    When user provides a valid email
    And user provides valid password
    Then user cliks on log in button
    Then verify user is loged in
