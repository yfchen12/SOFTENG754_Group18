@ADM_TEST @F2 @US_2 @US_61 @US_31
Feature: Course administrator creates new courses
  Must Have User Stories:
  2 - Modify course: As a course admin, I want to be able to modify course offerings, so that students can be informed with the latest course information.
  31 - Create course: As a course admin, I want to be able to create a new course, so that the list of courses reflects what are available to students.
  61 - Set Concession Criteria: As a course admin, I want to be able to set the criteria that student should met to get the

  @S4
  Scenario: Course admin create new course
    Given I login as a Course Administrator
    When I click create new course button from course manage page
    Then I should be redirected to create course information page
    When I finished all the mandatory information
    And I click submit button
    Then I should be redirected to course information page successful