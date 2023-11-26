@personalInfo
Feature: As a user applying for a mortgage loan, I want to provide my employment
  and income details to the bank, so that they can evaluate my eligibility for
  a loan



  Background: common steps
    Given User in logged in Mortgage application page

    Scenario: User tries to click on Employement and Income
      When User tries to navigate to Employement and Income window
      Then User gets error this field is required message on many fields

  Scenario: User fills out personal info for next
    When User fillouts personal information for loan
    And User clicks on Next button
    Then User should land in Expenses Page
