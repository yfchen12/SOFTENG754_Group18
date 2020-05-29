Feature: Search Course Test
  Student and course admin should be able to search course by different criteria

  Background:
    Given I login as a student

  Scenario Outline:
    Given I click search course button from Student Dashboard page
    When I search by "<criteria>"
    And I click search button
    Then the search result should be displayed on Search Result page
    Examples:
      | criteria |
      | courseNumber |
      | courseTitle  |