@STD_TEST
Feature: Student Check Enrollment Dates
  Student should be able see future enrollment dates

  Scenario: Check future enrollment dates
    Given I login as a student
    When I click check enrollment dates button
    Then I should see a list of future enrollment dates
