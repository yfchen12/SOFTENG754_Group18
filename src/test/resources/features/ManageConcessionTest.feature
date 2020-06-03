@ADM_TEST
Feature: Manage Concession Test
  Course admin should be able to approve, reject and set conessions for courses. Also be able set the concession open date

  Background:
    Given I login as a admin
    And I click manage concession from Admin Dashboard page

  Scenario: Set concession date for a course
    When I click edit button for the most recent concession open date
    And I change the date to tomorrow
    And I click confirm date change button
    Then the most recent concession open date should be tomorrow

  Scenario: Set concession criteria
    When I set concession criteria to have 2 years Java experience
    And I click save changes button
    Then I should see 2 years Java experience as the concession criteria

  Scenario: Reject course concession and cancelled
    When I click process button for student John Smith
    And I click reject button
    And I click cancel reject button
    Then John Smith should be in the list of new concessions

  Scenario: Reject course concession and confirmed
    When I click process button for student John Smith
    And I click reject button
    And I click confirm reject button
    Then John Smith should not be in the list of new concessions

  Scenario: Approve course concession
    When I click process button for student John Smith
    And I click approve concession button
    Then John Smith should not be in the list of new concessions