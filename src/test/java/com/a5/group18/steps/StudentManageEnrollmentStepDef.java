package com.a5.group18.steps;

import com.a5.group18.pages.MyEnrollmentPage;
import cucumber.api.java8.En;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentManageEnrollmentStepDef implements En {

    private MyEnrollmentPage myEnrollmentPage;

    @Autowired
    private UIGlobalState state;
    public StudentManageEnrollmentStepDef() {


        And("^I am on My Enrollment Page$", () -> {
            state.driver.get(state.url+"/myEnrollment");
        });
        When("^I click the text WAITLISTED$", () -> {
            state.wait.until(ExpectedConditions.titleIs("My Enrollment"));
            myEnrollmentPage = new MyEnrollmentPage(state.driver);
            myEnrollmentPage.waitlistLink.click();
        });
        Then("^I should be able to see there is (\\d+) student in front of me in the waiting list$", (Integer studentNum) -> {
            state.wait.until(ExpectedConditions.visibilityOf(myEnrollmentPage.modalContainer));
            Assertions.assertTrue(myEnrollmentPage.modalMsg.getText().contains(studentNum.toString()));
        });
        But("^I can not see the name of the student in front of me$", () -> {
            Assertions.assertFalse(myEnrollmentPage.modalMsg.getText().contains("allen"));
        });
    }
}
