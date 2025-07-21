Feature: Add product to cart and place an order

  @feature
  Scenario: User places an order without an account
    Given User opens the "home" page
    When user accepts cookies terms
    And user opens the product page "Hero Hoodie"
    Then user selects size "XS", color "Green" qty "1"
    When user click on Add to cart button
    Then user checks the successful message contains "You added Hero Hoodie"
    And the value in the mini-cart was updated at 1
    When user navigates to cart
    And user click on Proceed to checkout button
    And fills out the information for the shipping address
      | email          | first name | last name | street address | city      | state  | zipcode    | phone number | shippingMethod |
      | test@email.com | FirstName  | LastName  | Abc 123        | Timisoara | Alaska | 12345-6789 | 012345688    | Fixed          |
    Then user clicks on "Next" button
    And the page title is "Payment Method"
    And check the address summary on checkout page
      | FirstName LastName           |
      | Abc 123                      |
      | Timisoara, Alaska 12345-6789 |
      | United States                |
      | 012345688                    |
    And check the order summary on checkout page
      | field           | value             |
      | Cart Subtotal   | $54.00            |
      | Shipping        | $5.00             |
      | Shipping Method | Flat Rate - Fixed |
      | Order Total     | $59.00            |
    When user clicks on "Place Order" button
    Then the title of the page contains "Thank you for your purchase!"

  @feature
  Scenario: user place an order with an account
    Given User opens the "create account" page
    When user accepts cookies terms
    And user creates an account with first name "First", last name "Last" and password "Timisoara1"
    Then user checks the successful message contains "Thank you for registering with Main Website Store."
    And the title of the page contains "My Account"
    When  User opens the "bag category" page
    And user add the product "Driven Backpack" into the cart
    Then user checks the successful message contains "You added Driven Backpack"
    And the value in the mini-cart was updated at 1
    When user clicks on cart icon
    And user click on Proceed to checkout mini cart button
    And fills out the information for the shipping address
      | street address | city      | state  | zipcode    | phone number | shippingMethod |
      | Abc 123        | Timisoara | Alaska | 12345-6789 | 012345688    | Table Rate     |
    And user clicks on "Next" button
    And the page title is "Payment Method"
    Then check the address summary on checkout page
      | First Last                   |
      | Abc 123                      |
      | Timisoara, Alaska 12345-6789 |
      | United States                |
      | 012345688                    |
    And check the order summary on checkout page
      | field           | value                 |
      | Cart Subtotal   | $36.00                |
      | Shipping        | $20.00                |
      | Shipping Method | Best Way - Table Rate |
      | Order Total     | $56.00                |
    When user clicks on "Place Order" button
    Then the title of the page contains "Thank you for your purchase!"

  @feature
  Scenario: User place an order and change the quantity of the product
    Given User opens the "home" page
    When user accepts cookies terms
    And user opens the product page "Hero Hoodie"
    Then user selects size "XS", color "Green" qty "1"
    When user click on Add to cart button
    Then user checks the successful message contains "You added Hero Hoodie"
    And the value in the mini-cart was updated at 1
    When user navigates to cart
    And user update the qty the card with value "3"
    And check the order summary on cart page
      | field         | value   |
      | Cart Subtotal | $162.00 |
      | Order Total   | $162.00 |
    And user click on Proceed to checkout button
    And fills out the information for the shipping address
      | email          | first name | last name | street address | city      | state  | zipcode    | phone number | shippingMethod |
      | test@email.com | FirstName  | LastName  | Abc 123        | Timisoara | Alaska | 12345-6789 | 012345688    | Fixed          |
    Then user clicks on "Next" button
    And the page title is "Payment Method"
    And check the address summary on checkout page
      | FirstName LastName           |
      | Abc 123                      |
      | Timisoara, Alaska 12345-6789 |
      | United States                |
      | 012345688                    |
    And check the order summary on checkout page
      | field           | value             |
      | Cart Subtotal   | $162.00           |
      | Shipping        | $15.00            |
      | Shipping Method | Flat Rate - Fixed |
      | Order Total     | $177.00           |
    When user clicks on "Place Order" button
    Then the title of the page contains "Thank you for your purchase!"

  @feature
  Scenario: Search for a product and place an order
    Given User opens the "home" page
    When user accepts cookies terms
    And user use the search bar to search for "Overnight Duffle" product
    Then the title of the page contains "Search results for: 'Overnight Duffle'"
    When user add the product "Overnight Duffle" into the cart
    Then user checks the successful message contains "You added Overnight Duffle"
    And the value in the mini-cart was updated at 1
    When user navigates to cart
    And the product "Overnight Duffle" should be visible in the cart
    And user click on Proceed to checkout button
    And fills out the information for the shipping address
      | email          | first name | last name | street address | city      | state  | zipcode    | phone number | shippingMethod |
      | test@email.com | FirstName  | LastName  | Abc 123        | Timisoara | Alaska | 12345-6789 | 012345688    | Fixed          |
    Then user clicks on "Next" button
    And the page title is "Payment Method"
    And check the address summary on checkout page
      | FirstName LastName           |
      | Abc 123                      |
      | Timisoara, Alaska 12345-6789 |
      | United States                |
      | 012345688                    |
    And check the order summary on checkout page
      | field           | value             |
      | Cart Subtotal   | $45.00            |
      | Shipping        | $5.00             |
      | Shipping Method | Flat Rate - Fixed |
      | Order Total     | $50.00            |
    When user clicks on "Place Order" button
    Then the title of the page contains "Thank you for your purchase!"


    #for mobile only
  @feature @mobile @regression
  Scenario: User places an order without an account on mobile
    Given User opens the "home" page
    When user accepts cookies terms
    And user opens the product page "Hero Hoodie"
    Then user selects size "XS", color "Green" qty "1"
    When user click on Add to cart button
    Then user checks the successful message contains "You added Hero Hoodie"
    And the value in the mini-cart was updated at 1
    When user navigates to cart
    And user click on Proceed to checkout button
    And fills out the information for the shipping address
      | email          | first name | last name | street address | city      | state  | zipcode    | phone number | shippingMethod |
      | test@email.com | FirstName  | LastName  | Abc 123        | Timisoara | Alaska | 12345-6789 | 012345688    | Fixed          |
    Then user clicks on "Next" button
    And the page title is "Payment Method"
    And check the address summary on checkout page
      | FirstName LastName           |
      | Abc 123                      |
      | Timisoara, Alaska 12345-6789 |
      | United States                |
      | 012345688                    |
    And the estimated total value is "$59.00"
    When user clicks on "Place Order" button
    Then the title of the page contains "Thank you for your purchase!"