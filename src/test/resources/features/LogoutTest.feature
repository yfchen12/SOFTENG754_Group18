@STD_TEST @US_28
Feature: Logout test
  Must Have User Stories:
  28 - Logout: As a user, I want to be able to logout from the tool, so that I can end my session.

  Student and course admin should be able logout the system

  Scenario: Student logout
    Given I login as a student
    When I click Logout button
    Then I should be able to logout successfully
