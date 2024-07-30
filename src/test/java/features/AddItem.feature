Feature: Adding a single or multiple  Item in Cart

  @MonitorItem @AddItem
  Scenario: Adding a “Monitor” Item in Cart and verifying sub total displayed
    Given user is on the Amazon home Page
    When  the user searches for the "monitor" item
    And   selects the "1" item and add the item to the cart
    Then  the user navigates to the Cart Page
    And   the user verifies that the item price is identical to the product page
    And   also the the sub total is identical to the item price in the product page

  @LaptopItem @AddItem
  Scenario: Adding a “Monitor” Item in Cart and verifying sub total displayed
    Given user is on the Amazon home Page
    When  the user searches for the "Laptop" item
    And   selects the "2" item and add the item to the cart
    Then  the user navigates to the Cart Page
    And  the user verifies that the item price is identical to the product page
    And   also the the sub total is identical to the item price in the product page

  @TwoItem @AddItem
  Scenario: Adding both  “Monitor”  and "LapTop" Item in Cart and verifying sub total displayed
    Given user is on the Amazon home Page
    When  the user searches for the "monitor" item
    And   selects the "1" item and add the item to the cart
    And   the user searches for the "Laptop" item
    And   selects the "1" item and add the item to the cart
    Then  the user navigates to the Cart Page
    And   the user verifies that the item price is identical to the product page
    And   also the the sub total is identical to the item price in the product page