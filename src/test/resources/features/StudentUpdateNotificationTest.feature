@STD_TEST
Feature: Student Update Notification Test
  Student should be able to select what method of notification they want when course information is updated.

  Scenario: Set notification method to email
    Given I login as a student
    When I click update notification button
    And I select email as the preferred notification method
    And I click save button
    Then I should see a green banner saying preference saved