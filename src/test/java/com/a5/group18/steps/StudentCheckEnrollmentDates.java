package com.a5.group18.steps;

import com.a5.group18.pages.StdDashboardPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentCheckEnrollmentDates implements En {

    private StdDashboardPage studentDashPage;

    @Autowired
    private UIGlobalState state;
    public StudentCheckEnrollmentDates() {
        When("^I click check enrollment dates button$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Student Dashboard"));
            studentDashPage = new StdDashboardPage(state.driver);
            studentDashPage.btnCheckEnrollmentDates.click();
        });

        Then("^I should see a list of future enrollment dates$", () -> {
            state.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enrollmentDatesModal")));
            Assert.assertTrue(state.driver.getPageSource().contains("Below are the enrollment dates:"));
        });
    }
}
