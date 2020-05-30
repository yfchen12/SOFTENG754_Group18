package com.a5.group18.steps;

import cucumber.api.java8.En;

public class StudentTrackCourseStepDef implements En {
    public StudentTrackCourseStepDef() {
        When("^I click My Enrollment button from student dashboard page$", () -> {
        });
        Then("^I should be able to see \"([^\"]*)\" with status \"([^\"]*)\"$", (String courseNumber, String status) -> {
        });
    }
}
