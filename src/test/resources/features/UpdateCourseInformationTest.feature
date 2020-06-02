@Admin
Feature: Course administrator update course information

  Scenario Outline: Course admin edit one course
    Given I login as a Course Administrator
    When I click edit course button from admin Dashboard page
    Then I should be redirected to courses list page
    When I press edit button in the list
    Then I should be redirected to courses edit page
    When I finished all the updated information
    And I click submit update button
    Then I should be redirected to course information page successfully
    And Course information is successfully updated with <coursenum> and <coursetitle>
    Examples:
      | coursenum    | coursetitle                        |
      | "SOFTENG754" | "Advanced requirement development" |
