
Feature: Student check course outline

  Background:
    Given I login as a student

  Scenario Outline: Cart redirect
    And  I am in enrollment cart page
    When I click "<courseNumber>" in enroll cart list
    Then I should be redirected to "<courseNumber>" information page
    Examples:
      | courseNumber |
      | SOFTENG701   |
      | SOFTENG702   |
      | SOFTENG703   |


  Scenario Outline: Enrollment redirect
    And  I am in my enrollment page
    When I click "<courseNumber>" in my enrollment list
    Then I should be redirected to "<courseNumber>" information page
    Examples:
      | courseNumber |
      | SOFTENG701   |
      | SOFTENG702   |
      | SOFTENG703   |

  Scenario Outline: Search result redirect
    And  I am in search result page
    When I click "<courseNumber>" in the result list
    Then I should be redirected to "<courseNumber>" information page
    Examples:
      | courseNumber |
      | SOFTENG701   |
      | SOFTENG702   |
      | SOFTENG703   |

  Scenario Outline: teacher profile redirect
    And  I am in course information page
    When I click "<teacher>" list in the page
    Then I should be redirected to teacher profile page
    Examples:
      | teacher     |
      | John Walker |
      | Andy Jane   |

  Scenario Outline: download redirect
    And  I am in "<courseNumber>" course information page
    When I click download in the bottom of the page
    Then I should be able to download "<courseNumber>".pdf
    Examples:
      | courseNumber |
      | SOFTENG701   |
      | SOFTENG702   |
      | SOFTENG703   |