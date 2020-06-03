
Feature: Student check course outline
  Background:
    Given I login as a student

  Scenario Outline: Cart redirect
    And  I am in enrollment cart page
    When I click <CourseNumber> in enroll cart list
    Then I should be redirected to <CourseNumber> information page
    Examples:
      | CourseNumber |
      | "SOFTENG701"   |
      | "SOFTENG702"   |
      | "SOFTENG703"   |

  Scenario Outline: Enrollment redirect
    And  I am in my enrollment page
    When I click <CourseNumber> in my enrollment list
    Then I should be redirected to <CourseNumber> information page
    Examples:
      | CourseNumber |
      | "SOFTENG701"   |
      | "SOFTENG702"   |
      | "SOFTENG703"   |