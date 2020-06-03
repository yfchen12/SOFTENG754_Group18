package com.a5.group18.steps;

import cucumber.api.java8.En;

public class StudentEnrolIntoCourseStepDef implements En {

    public StudentEnrolIntoCourseStepDef() {
        Given("I am on cart page", () -> {
        });
        When("^I click the Enrol button of course \"([^\"]*)\"$", (String couresNum ) -> {
        });
        And("^I click the confirm button in the modal$", () -> {
        });
        Then("^I should be informed that I enrolled into the course successfully$", () -> {

        });
    }}


