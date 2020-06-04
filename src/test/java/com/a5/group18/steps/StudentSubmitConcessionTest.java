package com.a5.group18.steps;

import cucumber.api.java8.En;

public class StudentSubmitConcessionTest implements En {
    public StudentSubmitConcessionTest() {
        And("^I have started to submit a concession for course SOFTENG(\\d+)$", (Integer arg0) -> {
        });
        And("^I navigate to the concession submission page$", () -> {
        });
        When("^I fill in the concession form with the \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$", (String arg0, String arg1, String arg2) -> {
        });
        And("^I click the submit button$", () -> {
        });
        Then("^I should be notified the concession was submitted$", () -> {
        });
    }
}
