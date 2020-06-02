@STD_TEST
Feature: Cart management test

  Background: Student login
    Given I login as a student

  Scenario: Add a new course to the cart from course search result
    Given I found my desired course SOFTENG701 from search result
    When I click Add To Cart button
    Then the course should be added to cart successfully

  Scenario: Add a new course to the cart from course detail information page
    Given I found my desired course SOFTENG701 from search result
    And I click View Detail button to check course detail information
    When I click Add to Enrollment Cart button
    Then the course should be added to cart successfully

  Scenario: Delete course from cart
    Given I navigate to cart page
    When I click Delete button
    And the Confirmation alert should popup
    And I click Confirm button
    Then the course should be deleted from cart
