@STD_TEST @STD_ENROL
Feature: Student enrol into a course

  Background:
    Given I login as a Student
    Given I am on cart page

  Scenario: Student enrol into a course that satisfies all requirements
    When I click the Enrol button of course "SOFTENG705"
    And I click the confirm button in the modal
    Then I should be informed that I enrolled into the course successfully

  Scenario: Student enrol into a course that is full
    When I click the Enrol button of course "SOFTENG753"
    And I click the confirm button in the modal
    Then I should be informed that I the people in the waiting list is 4;

  Scenario: Student enrol into a course that requires concession
    When I click the Enrol button of course "SOFTENG752"
    And I click the confirm button in the modal
    Then I should be redirected to the concession information page
