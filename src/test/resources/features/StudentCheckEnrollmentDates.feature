@STD_TEST @US_17 @F10
Feature: Student Check Enrollment Dates
  Must Have User Stories:
  17 - Enrollment open date: As a student, I would like to see the enrollment open date in the system, so that I will not miss the enrollment date.

  Student should be able see future enrollment dates

  @S23
  Scenario: Check future enrollment dates
    Given I login as a student
    When I click check enrollment dates button
    Then I should see a list of future enrollment dates
