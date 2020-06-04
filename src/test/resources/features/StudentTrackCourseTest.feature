@STD_TEST @US_60 @F14
Feature: Student tracks selected course status
  Must Have User Stories:
  60 - Track Selected Course: As a student, I want to be able see what courses I have reserved a spot to, so that I can keep track of what has been selected.

  @S31
  Scenario Outline: Student track selected course status
    Given I login as a student
    When I click My Enrollment button from student dashboard page
    Then I should be able to see "<courseNumber>" with status "<status>"
    Examples:
      | courseNumber | status             |
      | SOFTENG701   | ENROLLED           |
      | SOFTENG703   | CONCESSION_PENDING |

