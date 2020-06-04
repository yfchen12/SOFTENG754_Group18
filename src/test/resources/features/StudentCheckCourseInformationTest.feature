@STD_TEST @US_42 @US_21 @US_45 @F7
Feature: Student check course information
  Must Have User Stories:
  21 - Ability to check the course outline: As a student, I want to be able to see the course outline from the system, so that I can know if the course suits me in terms of content and structure.
  42 - Course Prerequisites: As a student, I want to see what are the prerequisites of selected courses, so that I know if I can estimate when I can take the selected course.
  45 - Course Value: As a student, I want to know what are the practical skills/knowledge the course offers, so that I know how can the course help my career.

  Background:
    Given I login as a student
    And  I am in student dash board page

  @S16
  Scenario Outline: Cart redirect to course information
    And  I am in enrollment cart page
    When I click "<courseNumber>" in enroll cart list
    Then I should be redirected to "<courseNumber>" information page
    Examples:
      | courseNumber |
      | SOFTENG701   |

  @S17
  Scenario Outline: Enrollment redirect to course information
    And  I am in my enrollment page
    When I click "<courseNumber>" in my enrollment list
    Then I should be redirected to "<courseNumber>" information page
    Examples:
      | courseNumber |
      | SOFTENG701   |

  @US_36 @S18
  Scenario Outline: Search result redirect to course information
    And  I am in search result page
    When I click "<courseNumber>" in the result list
    Then I should be redirected to "<courseNumber>" information page
    Examples:
      | courseNumber |
      | SOFTENG701   |

  @S19
  Scenario: redirect to teacher profile from course information
    And  I am in course information page
    When I click Andy Jane in the page
    Then I should be redirected to teacher profile page

  @S20
  Scenario Outline: download course information
    And  I am in "<courseNumber>" course information page
    When I click download in the bottom of the page
    Then I should be able to download "<courseNumber>".pdf
    Examples:
      | courseNumber |
      | SOFTENG701   |
