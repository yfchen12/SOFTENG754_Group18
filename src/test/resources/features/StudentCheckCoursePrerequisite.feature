@STD_TEST @US_42
Feature: Student check course prerequisite
  Must Have User Stories:
  42 - Course Prerequisites: As a student, I want to see what are the prerequisites of selected courses, so that I know if I can estimate when I can take the selected course.

  Scenario: should be able to check course prerequisite
    Given I login as a student
    When  I am in SOFTENG701 course information pages
    Then I should be able to see the course prerequisite
    And  I should be able to redirected to course information through prerequisite course name
