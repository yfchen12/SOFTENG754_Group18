Feature: Login vis UoA SSO
  Must Have User Stories:
  27 - Login: As a user, I want to be able to login the tool with my UoA SSO, so that I don’t need to register separately.

  This feature test should contain course admin login via SSO and student login via SSO

  @ADM_TEST @US_27
  Scenario: Course admin login via SSO
    Given open UoA course enrollment website
    When I click login via SSO button
    Then I should be redirected to UoA SSO page
    When I enter my user credentials tim.shi@uoa.com and 123
    And I click login button
    Then I should be login to dashboard page successful

  @STD_TEST @US_27
  Scenario: Student login via SSO
    Given open UoA course enrollment website
    When I click login via SSO button
    Then I should be redirected to UoA SSO page
    When I enter my user credentials john.smith@uoa.com and 123
    And I click login button
    Then I should be login to student dashboard page successful