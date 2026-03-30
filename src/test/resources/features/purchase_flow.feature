Feature: Purchase Flow in OpenCart

  Scenario: Successful purchase of two products as a guest user
    Given the user is on the OpenCart home page
    When the user navigates to the "Phones & PDAs" section
    And the user adds the first product to the cart
    And the user adds the second product to the cart
    And the user views the shopping cart
    And the user proceeds to checkout
    And the user selects the "Guest Checkout" option and continues
    And the user fills in the billing details:
      | firstName | lastName | email                     | telephone  | address         | city     | postCode | country       | zone     |
      | John      | Doe      | john.doe@abstracta.us     | 5551234567 | 123 Main Street | New York | 10001    | United States | New York |
    And the user continues through the delivery method
    And the user accepts the terms and conditions and continues
    And the user confirms the order
    Then the order is placed successfully with the message "Your order has been placed!"
