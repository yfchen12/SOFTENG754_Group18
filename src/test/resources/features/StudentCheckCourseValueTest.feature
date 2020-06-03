
Feature: Student check course value
  Background:
    Given I login as a student

  Scenario Outline: should be able to check course value
    When  I am in course information page
    Then I should be able to see the course value
    And  I should be able to see the <ValueType> and <LastChecktime> by <Company>
    Examples:
      | ValueType         | LastChecktime | Company |
      | "PotentialCareer" | "20190506"    | "Xero,Microsoft,Google"  |

