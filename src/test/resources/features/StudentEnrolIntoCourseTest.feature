@STD_TEST @STD_ENROL
Feature: Student enrol into a course
  Background:
    Given I login as a Student
    Given I am on cart page

  Scenario: Student enrol into a course that satisfies all requirements
    When I click the Enrol button of course "SOFTENG750"
    And I click the confirm button in the modal
    Then I should be informed that I enrolled into the course successfully



