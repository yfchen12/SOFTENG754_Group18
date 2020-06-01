@STUD_TEST
Feature: Students manage their enrollments

  Scenario: Students track their places in waiting list of an enrollment with WAITLISTED status
    Given I login as a Student
    And I am on My Enrollment Page
    When I click the text WAITLISTED
    Then I should be able to see there is 1 student in front of me in the waiting list
    But I can not see the name of the student in front of me

  @SUCCESSDROP_TEST
  Scenario: Students are notified when successfully dropping a course from the enrollment list
    Given I login as a Student
    And I am on My Enrollment Page
    When I click the drop button of course SOFTENG702
    And I click the confirm button in the modal window
    Then I should be able to notify the course is dropped successfully

  @RMCOURSE_TEST
  Scenario: Students can see updated enrollment list when successfully dropping a course
    Given I login as a Student
    And I am on My Enrollment Page
    When I click the drop button of course SOFTENG702
    And I click the confirm button in the modal window
    And I click the ok button on the alert window
    Then I should see the dropped course is removed from the enrollment list
