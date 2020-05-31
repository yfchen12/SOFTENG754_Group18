Feature: Course administrator creates new courses
  Scenario: Course admin create new course
    Given I login as a Course Administrator
    When I click create new course button from admin Dashboard page
    Then I should be redirected to create course information page
    When I finished all the mandatory information
    And I click submit button
    Then I should be redirected to course information page successful