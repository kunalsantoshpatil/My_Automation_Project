
Feature: Search Product Functionality
@Search
  Scenario: Testing product searching functionality
    Given User has already login and present on Home page
    When user click on products tab
    Then user should navigate to All product page
    When user search Tshirt in search box
    And click on Search icon
    Then searched product should be visible
    And Verify product details page should be visible
