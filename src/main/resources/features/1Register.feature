Feature: Testing Registration functionality

  Scenario: Register with valid credentials
    Given User is on Automation-Exercise Home Page
    When User click on Register
    Then Registration Page should open
    When user enters valid details with firstname, lastname, email, and password
    And clicks on Register button
    Then user should be Successfully Registered
    And click on Logout
    When User Enter Registered email and password & click on Sign In
    Then Welcome page should be displayed
    When user click on Delete Account
    Then Account Deleted message should be displayed
