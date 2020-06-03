Feature: Student tracks selected course status

  @STD_TEST
  Scenario Outline: Student track selected course status
    Given I login as a student
    When I click My Enrollment button from student dashboard page
    Then I should be able to see "<courseNumber>" with status "<status>"
    Examples:
      | courseNumber | status             |
      | SOFTENG701   | ENROLLED           |
      | SOFTENG703   | CONCESSION_PENDING |

