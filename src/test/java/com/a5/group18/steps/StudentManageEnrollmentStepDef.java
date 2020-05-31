package com.a5.group18.steps;
import cucumber.api.java8.En;

public class StudentManageEnrollmentStepDef implements En {

    public StudentManageEnrollmentStepDef() {
        And("^I am on My Enrollment Page$", () -> {
        });
        When("^I click the text WAITLISTED$", () -> {
        });
        Then("^I should be able to see there is (\\d+) student in front of me in the waiting list$", (Integer studentNum) -> {
        });
        But("^I can not see the name of the student in front of me$", () -> {
        });
    }
}
