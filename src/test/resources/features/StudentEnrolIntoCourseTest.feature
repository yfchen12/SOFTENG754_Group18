@STD_TEST @US_58 @F11
Feature: Student enrol into a course
  Must Have User Stories:
  58 - Enroll into course: As a student, I want to be able to enroll into courses, so that I can reserve a spot in the selected course.
  5 - Waiting list transparency: As a student, I want to be able to see how many students are in front of me in the concession waiting list, so that I know how likely it is for me to get accepted.

  Background:
    Given I login as a Student
    Given I am on cart page

  @S24
  Scenario: Student enrol into a course that satisfies all requirements
    When I click the Enrol button of course "SOFTENG705"
    And I click the confirm button in the modal
    Then I should be informed that I enrolled into the course successfully

  @US_5 @S25
  Scenario: Student enrol into a course that is full
    When I click the Enrol button of course "SOFTENG753"
    And I click the confirm button in the modal
    Then I should be informed that I the people in the waiting list is 4;

  @S26
  Scenario: Student enrol into a course that requires concession
    When I click the Enrol button of course "SOFTENG752"
    And I click the confirm button in the modal
    Then I should be redirected to the concession information page
