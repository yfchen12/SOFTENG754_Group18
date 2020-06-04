@STD_TEST @US_45 @F9
Feature: Student check course value
  Must Have User Stories:
  45 - Course Value: As a student, I want to know what are the practical skills/knowledge the course offers, so that I know how can the course help my career.

  @S22
  Scenario Outline: should be able to check course value
    Given I login as a student
    When  I am in course information pages
    Then I should be able to see the course value
    And  I should be able to see the "<valueType>" and "<lastChecktime>" by "<company>"
    Examples:
      | valueType       | lastChecktime | company               |
      | PotentialCareer | 20190506      | Xero,Microsoft,Google |

