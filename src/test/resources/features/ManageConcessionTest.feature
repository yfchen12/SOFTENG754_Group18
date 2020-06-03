@ADM_TEST
Feature: Manage Concession Test
  Course admin should be able to approve, reject and set conessions for courses. Also be able set the concession open date

  Scenario: Set concession date for a course
    Given I login as a admin
    And I click manage concession from Admin Dashboard page
    When I click edit button for the most recent concession open date
    And I change the date to tomorrow
    And I click confirm date change button
    Then the most recent concession open date should be tomorrow