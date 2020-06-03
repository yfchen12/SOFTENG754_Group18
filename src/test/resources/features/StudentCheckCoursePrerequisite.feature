Feature: Student check course prerequisite
  Background:
    Given I login as a student


  Scenario: should be able to check course prerequisite
    When  I am in course information page
    Then I should be able to see the course prerequisite
    And  I should be able to redirected to course information through prerequisite course name
