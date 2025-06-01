Feature: Checkout functionality

 @Checkout
  Scenario: Testing safe checkout transactions
    Given User has added product to the cart
    When User click on Proceed to checkout
    And click on Place order
    Then Payement page should open
    When user enter payment detailclick on Pay & confirm order
    Then your order has been placed successfully this msg should come
