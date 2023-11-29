@LUMAShoppingCart
Feature: LUMA webpage shopping cart functionality

  @VerifyValidProductHasBeenAddedToTheShoppingCart
  Scenario: Verify if the correct product has been added to the cart correctly
    Given user choose an product and add this to the shopping cart
    When user navigate to the shopping cart option
    Then user verify the valid product is added