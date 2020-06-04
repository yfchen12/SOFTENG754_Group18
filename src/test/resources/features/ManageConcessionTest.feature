@ADM_TEST
Feature: Manage Concession Test
  Must Have User Stories:
  19 - Approve course concession: As a course admin, I want to be able to approve the course concession, so that students can be enrolled in the course if they have a justification.
  26 - Concession Open Date: As a course admin, I want to be able to set a concession open date that is before the enrolment date so that students know their concession result prior to enrolment.
  12 - Immediate concession approve: As a student, I want to know if my course concession has been approved or not straight away, so that I can submit my enrolments when I am allowed to.

  Course admin should be able to approve, reject and set concessions for courses. Also be able set the concession open date

  Background:
    Given I login as a admin
    And I click manage concession from Admin Dashboard page

  @US_26
  Scenario: Set concession date for a course
    When I click edit button for the most recent concession open date
    And I change the date to tomorrow
    And I click confirm date change button
    Then the most recent concession open date should be tomorrow

  @US_12
  Scenario: Set concession criteria
    When I set concession criteria to have 2 years Java experience
    And I click save changes button
    Then I should see 2 years Java experience as the concession criteria

  @US_19
  Scenario: Reject course concession and cancelled
    When I click process button for student John Smith
    And I click reject button
    And I click cancel reject button
    Then John Smith should be in the list of new concessions

  @US_19
  Scenario: Reject course concession and confirmed
    When I click process button for student John Smith
    And I click reject button
    And I click confirm reject button
    Then John Smith should not be in the list of new concessions

  @US_19
  Scenario: Approve course concession
    When I click process button for student John Smith
    And I click approve concession button
    Then John Smith should not be in the list of new concessions