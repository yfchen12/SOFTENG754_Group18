@MANAGEENROL_TEST
Feature: Students manage their enrollments

  Scenario: Students track their places in waiting list of an enrollment with WAITLISTED status
    Given I login as a Student
    And I am on My Enrollment Page
    When I click the text WAITLISTED
    Then I should be able to see there is 1 student in front of me in the waiting list
    But I can not see the name of the student in front of me