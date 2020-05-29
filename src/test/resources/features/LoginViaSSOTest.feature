Feature: Login vis UoA SSO
  This feature test should contain course admin login via SSO and student login via SSO

Scenario: Course admin login via SSO
  Given open UoA course enrollment website
  When I click login via SSO button
  Then I should be redirected to UoA SSO page
  When I enter my user credentials tim.shi@uoa.com and 123
  And I click login button
  Then I should be login to dashboard page successful

Scenario: Student login via SSO
  Given open UoA course enrollment website
  When I click login via SSO button
  Then I should be redirected to UoA SSO page
  When I enter my user credentials tim.shi@uoa.com and 123
  And I click login button
  Then I should be login to student dashboard page successful