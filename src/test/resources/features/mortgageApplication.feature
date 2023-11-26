@dashboard
Feature: As a user who has applied for a mortgage with a bank, I want to be able to
  access the dashboard page of the bank's mortgage application system so
  that I can view my account information, apply for a new mortgage, and
  view a list of my previous mortgage applications

  Background: common steps
    Given User in logged in dashboard page and profile are displayed

#  Scenario: Dashboard page includes links for Mortgage Application and Application List
#    When the user navigates to the dashboard page
#    Then the dashboard page should contain a link for "Mortgage Application"
#    And the dashboard page should contain a link for "Application List"

  Scenario:Navigate to new mortgage application page
    When User clicks on Mortgage Application
    Then User should be taken new page where user can apply for mortgage

  Scenario:Navigate to Application List page
    When User clicks on Application List
    Then User should be taken new page where user can see list