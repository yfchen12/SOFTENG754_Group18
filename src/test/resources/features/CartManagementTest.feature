@STD_TEST
Feature: Cart management test

  Background: Student login
    Given I login as a student

  Scenario: Add a new course to the cart from course search result
    Given I found my desired course SOFTENG701 from search result
    When I click Add To Cart button
    Then the course should be added to cart successfully
