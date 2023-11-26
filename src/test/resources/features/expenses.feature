@expenses
Feature: As a user should be able to put expenses and move forward

  Scenario: User puts his expenses and move forward
    Given User in expenses page
    When User puts his/her expenses
    Then User should be able to move to Employement page