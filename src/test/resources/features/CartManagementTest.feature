@STD_TEST
Feature: Cart management test
  Must Have User Stories:
  69 - Add course to cart: As a student, I want to be able to add selected courses to the enrollment cart, so that I can save my preferences.
  51 - Drop Selected Course: As a student, I want to cancel the selected courses, so that I can change my mind anytime before the enrollment is registered
  36 - Search course: As a student, I want to be able to search for a course, so that I can filter out unwanted courses.

  Background: Student login
    Given I login as a student

  @US_36 @US_69
  Scenario: Add a new course to the cart from course search result
    Given I found my desired course SOFTENG701 from search result
    When I click Add To Cart button
    Then the course should be added to cart successfully

  @US_36 @US_69
  Scenario: Add a new course to the cart from course detail information page
    Given I found my desired course SOFTENG701 from search result
    And I click View Detail button to check course detail information
    When I click Add to Enrollment Cart button
    Then the course should be added to cart successfully

  @US_51
  Scenario: Delete course from cart
    Given I navigate to cart page
    When I click Delete button
    And the Confirmation alert should popup
    And I click Confirm button
    Then the course should be deleted from cart
