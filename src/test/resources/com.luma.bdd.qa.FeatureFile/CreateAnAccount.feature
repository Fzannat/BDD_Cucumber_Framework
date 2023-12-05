@LUMACreateAnAccount
Feature: LUMA webpage create an account functionality



    @CreateAnAccountWithAllDetail
    Scenario: create an account with all detail
      Given user navigate to create an account page
      When user entered all the below field
        | firstName | Fatema       |
        | lastName  | Zannat       |
        | password  | Selenium@123 |
      And user clicked on createAnAccount button
      Then user Account gets created

  @CreateAnAccountWithDuplicateEmail
  Scenario: create an account with duplicate email
    Given user navigate to create an account page
    When user entered all the below with duplicateEmail
      | firstName       | Fatema       |
      | lastName        | Zannat       |
      | password        | Selenium@123 |
      | confirmPassword | Selenium@123 |
    And user clicked on createAnAccount button
    Then user gets error massage for using duplicate email

  @CreateAnAccountWithNoDetail
  Scenario: create an account with no detail
    Given user navigate to create an account page
    And user clicked on createAnAccount button

    Then user gets error messages for all required fields