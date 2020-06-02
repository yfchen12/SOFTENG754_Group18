@STUD_TEST @MANAGE_EN_TEST
Feature: Students manage their enrollments

  Background:
    Given I login as a Student
    And I am on My Enrollment Page

  Scenario: Students track their places in waiting list of an enrollment with WAITLISTED status
    When I click the text WAITLISTED
    Then I should be able to see there is 1 student in front of me in the waiting list
    But I can not see the name of the student in front of me

  Scenario Outline: Students are notified the result when dropping a course
    When I click the drop button of course "<courseNumber>"
    And I click the confirm button in the modal window
    Then I should see on the alert box that the course is "<result>" to drop because "<reason>"
    Examples:
      | courseNumber | result  | reason                                               |
      | SOFTENG701   | Failed  | can not be dropped because it is a compulsory course |
      | SOFTENG702   | Succeed | Successfully dropped                                 |

  Scenario: Students can see updated enrollment list when successfully dropping a course
    When I click the drop button of course "SOFTENG704"
    And I click the confirm button in the modal window
    And I click the ok button on the alert window
    Then I should see the dropped course is removed from the enrollment list

