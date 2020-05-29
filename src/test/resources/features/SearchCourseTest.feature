Feature: Search Course Test
  Student and course admin should be able to search course by different criteria

  Background:
    Given I login as a student
    And I click search course button from Student Dashboard page

  Scenario Outline: Search course by single criteria
    Given I search by "<criteria>" with value "<value>"
    When I click search button
    Then the search result should be displayed on Search Result page
    Examples:
      | criteria     | value           |
      | courseNumber | SOFTENG701      |
      | courseTitle  | OOP Development |