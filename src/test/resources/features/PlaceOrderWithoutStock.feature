Feature: Place order without success

  @feature
  Scenario Outline: User place order with a product out of stock or not enough stock
    Given User opens the "home" page
    When user accepts cookies terms
    Then user opens the product page "<productName>"
    And user insert qty "<qty>"
    When user click on Add to cart button
    Then user checks the error message contains "<errorMessage>"
    When user clicks on cart icon
    Then the message in the mini cart is "You have no items in your shopping cart."

    Examples:
      | productName           | qty | errorMessage                                      |
      | Push It Messenger Bag | 1   | The requested qty is not available                |
      | Fusion Backpack       | 3   | The requested qty is not available                |
      | Fusion Backpack       | 1.5 | You cannot use decimal quantity for this product. |

  @feature
  Scenario Outline: User place order with qty less than 1
    Given User opens the "home" page
    When user accepts cookies terms
    Then user opens the product page "Fusion Backpack"
    And user insert qty "<qty>"
    When user click on Add to cart button
    Then user gets the error "<errorMsg>" for qty
    When user clicks on cart icon
    Then the message in the mini cart is "You have no items in your shopping cart."

    Examples:
      | qty   | errorMsg                                |
      | 0     | Please enter a quantity greater than 0. |
      | -1    | Please enter a quantity greater than 0. |
      | 15555 | The maximum you may purchase is 10000.  |