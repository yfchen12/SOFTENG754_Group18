
Feature: Student check course information

  Background:
    Given I login as a student
    And  I am in student dash board page

  Scenario Outline: Cart redirect to course information
    And  I am in enrollment cart page
    When I click "<courseNumber>" in enroll cart list
    Then I should be redirected to "<courseNumber>" information page
    Examples:
      | courseNumber |
      | SOFTENG701   |



  Scenario Outline: Enrollment redirect to course information
    And  I am in my enrollment page
    When I click "<courseNumber>" in my enrollment list
    Then I should be redirected to "<courseNumber>" information page
    Examples:
      | courseNumber |
      | SOFTENG701   |


  Scenario Outline: Search result redirect to course information
    And  I am in search result page
    When I click "<courseNumber>" in the result list
    Then I should be redirected to "<courseNumber>" information page
    Examples:
      | courseNumber |
      | SOFTENG701   |


  Scenario: redirect to teacher profile from course information
    And  I am in course information page
    When I click Andy Jane in the page
    Then I should be redirected to teacher profile page


  Scenario Outline: download course information
    And  I am in "<courseNumber>" course information page
    When I click download in the bottom of the page
    Then I should be able to download "<courseNumber>".pdf
    Examples:
      | courseNumber |
      | SOFTENG701   |
