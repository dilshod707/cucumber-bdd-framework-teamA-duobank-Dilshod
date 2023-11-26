@signup
Feature: User signs up as new user

  Background:Common steps for signup
  Given The user clicks on the sign up link

  @regression
  Scenario: Sign up with valid information
    When The user fills up the fields with valid info
    Then user should be able to navigate to login page

  @existing_email
  Scenario: Sign up with existing email address
    When The user enters existing email
    Then This email already used should be displayed
