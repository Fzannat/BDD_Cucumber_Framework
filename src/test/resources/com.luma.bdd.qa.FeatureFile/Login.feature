@LUMALogin
Feature: LUMA webpage login functionality


  @LoginWithValidCredential
  Scenario: Login with a valid credential
    Given user navigate to SignIn page
    When user entered valid email 'fatema@gmail.com'
    And user entered valid password 'Selenium@123'
    And user clicked on signIn button
    Then user navigate to my account page

  @LoginWithValidEmailInvalidPassword
  Scenario: Login with a valid email invalid password
    Given user navigate to SignIn page
    When user entered valid email 'fatema@gmal.com'
    And user entered invalid password 'Selenium@1234'
    And user clicked on signIn button
    Then user gets credential mismatch warning message

  @LoginWithInvalidEmailValidPassword
  Scenario: Login with invalid email valid password
    Given user navigate to SignIn page
    When user entered invalid email 'fatema1@gmal.com'
    And user entered valid password 'Selenium@123'
    And user clicked on signIn button
    Then user gets credential mismatch warning message
  @LoginWithInvalid
  Scenario: Login with invalid email valid password
    Given user navigate to SignIn page
    When user entered invalid email 'fatema1@gmal.com'
    And user entered valid password 'Selenium@123'
    And user clicked on signIn button
    Then user gets credential mismatch warning message

  @LoginWithoutCredential
  Scenario: Login without credential
    Given user navigate to SignIn page
    And user clicked on signIn button
    Then user gets credential missing warning message
