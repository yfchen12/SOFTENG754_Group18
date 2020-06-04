@STD_TEST @US_56
Feature: Student submit concession

  Scenario Outline: Student submit concession
    Given I login as a student
    And I have started to submit a concession for course SOFTENG752
    And I navigate to the concession submission page
    When I fill in the concession form with the "<reason>", "<justification>" and "<file>"
    And I click the submit button
    Then I should be notified the concession was submitted

    Examples:
      | reason                  | justification                     | file |
      | HAVE_SIMILAR_EXPERIENCE | I have 2 years working experience | null |
