Feature: Logout test
  Student and course admin should be able logout the system

  @STD_TEST
  Scenario: Student logout
    Given I login as a student
    When I click Logout button
    Then I should be able to logout successfully
