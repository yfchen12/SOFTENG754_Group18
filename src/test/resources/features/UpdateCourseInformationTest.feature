@ADM_TEST @US_2 @F16
Feature: Course administrator update course information
  Must Have User Stories:
  32 - Manage course status: As a course admin, I want to be able to change course status, so that I can manage the course availability.
  2 - Modify course: As a course admin, I want to be able to modify course offerings, so that students can be informed with the latest course information.

  Background:
    Given I login as a Course Administrator
    When I click edit course button from admin Dashboard page
    And Redirected to courses list page
    Then I press edit button in the list
    And I should be redirected to courses edit page

  @US_32 @S34
  Scenario: Course admin update course status
    Given I update the course status to unavailable
    When I click submit update button
    Then I should be redirected to course information page successfully

  @S35
  Scenario: Course admin edit one course
    Given I update the course title and its details
    When I click submit update button
    Then I should be redirected to course information page successfully
