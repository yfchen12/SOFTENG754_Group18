package com.a5.group18.steps;

import com.a5.group18.pages.MyEnrollmentPage;
import com.a5.group18.pages.StdDashboardPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentTrackCourseStepDef implements En {
    private StdDashboardPage stdDashPage;
    private MyEnrollmentPage myEnrollmentPage;

    @Autowired
    private UIGlobalState state;

    public StudentTrackCourseStepDef() {
        When("^I click My Enrollment button from student dashboard page$", () -> {
            stdDashPage = new StdDashboardPage(state.driver);
            myEnrollmentPage = new MyEnrollmentPage(state.driver);
            stdDashPage.btnMyEnrollment.click();
        });
        Then("^I should be able to see \"([^\"]*)\" with status \"([^\"]*)\"$", (String courseNumber, String status) -> {
            state.wait.until(ExpectedConditions.titleIs("My Enrollment"));
            WebElement actualStatus;
            switch (courseNumber) {
                case "SOFTENG701":
                    actualStatus = myEnrollmentPage.se701Status;
                    break;
                case "SOFTENG702":
                    actualStatus = myEnrollmentPage.se702Status;
                    break;
                case "SOFTENG703":
                    actualStatus = myEnrollmentPage.se703Status;
                    break;
                default:
                    actualStatus = null;
                    break;
            }
            Assert.assertEquals(status, actualStatus.getText());
        });
    }
}
