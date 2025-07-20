Feature: Delete product from cart

#  @regression
  @feature
  Scenario: User deletes the product from cart
    Given User opens the "home" page
    When user accepts cookies terms
    And user opens the product page "Hero Hoodie"
    Then user selects size "XS", color "Green" qty "1"
    When user click on Add to cart button
    Then user checks the successful message contains "You added Hero Hoodie"
    And the value in the mini-cart was updated at 1
    When user navigates to cart
   And user delete the product from cart
    Then the title of the page is "Shopping Cart"
  And the empty cart message should be "You have no items in your  shopping  cart."