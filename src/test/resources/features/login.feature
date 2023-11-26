@login
Feature: User logs in with valid username and password

  Background: common steps for login scenarios
    Given The user is on login page

  @regression
  @valid_login
  Scenario Outline: Log in with valid information
    When The user fills up valid "<username>" and "<password>"
    Then user should be able to navigate to homepage
    Examples:
      | username              | password     |
      | davidme1988@gmail.com | Duoteck@2023 |
#      | kate@gmail.com         | duoteck@2023 |

  @regression
  @invalid_login
  Scenario: Unsuccesfull login with invalid credentials using Datatable
    When The user enters invalid credentials
      | fairfax1988@gmail.com | Duoteck@2023 |
    And User clicks on sing in button
    Then Error massage should appear




