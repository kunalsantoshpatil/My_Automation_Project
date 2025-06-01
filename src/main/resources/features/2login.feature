Feature: Login Functionality

@Login
  Scenario: Testing login functionality with valid data
    Given User has already registered and present on Home page
    When User click on signup_login button
    Then verify login page should open
    When User enter valid Credentials
    And click on Login
    Then welcome page should displayed