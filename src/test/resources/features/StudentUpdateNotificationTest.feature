@STD_TEST
Feature: Student Update Notification Test
  Student should be able to select what method of notification they want when course information is updated.

  Background:
    Given I login as a student
    When I click update notification button

  Scenario: Set notification method to email
    And I select email as the preferred notification method
    And I click save button
    Then I should see a green banner saying preference saved

  Scenario: Set items to be notified with
    And I select concession open date
    And I select course information
    And I select enrollment deadline
    And I select enrollment status change
    And I click save button
    Then I should see a green banner saying preference saved