@LUMASearchProduct
Feature: LUMA webpage search product functionality

  @VerifySearchProductPage
  Scenario: Verify search product
    Given user enter a product name in the search box
    When user clicked on a product
    Then user navigate to product detail page