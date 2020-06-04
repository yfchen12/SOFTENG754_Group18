@STUD_TEST @US_60 @F12
Feature: Students manage their enrollments
  Must Have User Stories:
  5 - Waiting list transparency: As a student, I want to be able to see how many students are in front of me in the concession waiting list, so that I know how likely it is for me to get accepted.
  60 - Track Selected Course: As a student, I want to be able see what courses I have reserved a spot to, so that I can keep track of what has been selected.
  70 - Unenroll from a course: As a student, I want to unenroll from a course, so that I can change my mind if the course is not suitable for me.

  Background:
    Given I login as a Student
    And I am on My Enrollment Page

  @US_5 @S27
  Scenario: Students track their places in waiting list of an enrollment with WAITLISTED status
    When I click the text WAITLISTED
    Then I should be able to see there is 1 student in front of me in the waiting list
    But I can not see the name of the student in front of me

  @US_70 @S28
  Scenario Outline: Students are notified the result when dropping a course
    When I click the drop button of course "<courseNumber>"
    And I click the confirm button in the modal window
    Then I should see on the alert box that the course is "<result>" to drop because "<reason>"
    Examples:
      | courseNumber | result  | reason                                               |
      | SOFTENG701   | Failed  | can not be dropped because it is a compulsory course |
      | SOFTENG702   | Succeed | Successfully dropped                                 |

  @US_70 @S29
  Scenario: Students can see updated enrollment list when successfully dropping a course
    When I click the drop button of course "SOFTENG704"
    And I click the confirm button in the modal window
    And I click the ok button on the alert window
    Then I should see the dropped course is removed from the enrollment list

