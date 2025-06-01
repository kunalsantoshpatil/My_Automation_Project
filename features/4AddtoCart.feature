Feature: Add to cart Functionality

  Background: 
    Given User is on product details page
    When user click on Add to cart
    Then product should be added to cart
    Then user click on View cart

  @AddtoCart
  Scenario: Testing Add to cart functionality
    Then product should be visible

  @AddtoCart
  Scenario: Updating quantity of product
    When update product quantity
    And click on Add to cart again
    Then user click on View cart

  @AddtoCart
  Scenario: Testing Remove from  cart functionality
    When User remove product from cart
    And verify product should be deleted from cart
