package com.a5.group18.steps;

import com.a5.group18.pages.AddNewCoursePage;
import com.a5.group18.pages.AdminDashboard;
import com.a5.group18.pages.CourseManagePage;
import com.a5.group18.pages.CourseUpdatePage;
import com.a5.group18.pojo.Course;
import cucumber.api.java8.En;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdateCourseInformationStepdefs implements En {
    private AdminDashboard adminDashPage;
    private CourseUpdatePage courseUpdatePage;
    private CourseManagePage courseManagePage;
    @Autowired
    private UIGlobalState state;

    public UpdateCourseInformationStepdefs() {
        When("^I click edit course button from admin Dashboard page$", () -> {
            adminDashPage = new AdminDashboard(state.driver);
            courseUpdatePage = new CourseUpdatePage(state.driver);
            courseManagePage = new CourseManagePage(state.driver);
            adminDashPage.btnUpdateCourse.click();
        });
        Then("^I should be redirected to courses list page$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Course Manage"));
        });
        When("^I press edit button in the list$", () -> {
            courseManagePage.manageAction.get(1).click();
        });
        Then("^I should be redirected to courses edit page$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Edit Course"));
        });
        When("^I finished all the updated information$", () -> {
            courseUpdatePage.coursenum.sendKeys("SOFTENG754");
            courseUpdatePage.coursetitle.sendKeys("Advanced requirement development");
            courseUpdatePage.courseshedule.sendKeys("Wednesday 3:00-4:00");
            courseUpdatePage.coutline.sendKeys("Learn how to elicit requirements from customers/users, write requirement specification and perform requirements analysis. Focus on the problem, not the solution.");
            courseUpdatePage.cvalue.sendKeys("Vocational skills by Xero 2020 March 3rd");
            courseUpdatePage.cpre.sendKeys("SOFTENG201");
            courseUpdatePage.tteam.sendKeys("Kelly Blincoe");
            courseUpdatePage.cstatus.sendKeys("NotAvailable");
            courseUpdatePage.ccapacity.sendKeys("150");
            courseUpdatePage.ccampus.sendKeys("CityCampus");
        });
        And("^I click submit update button$", () -> {
            courseUpdatePage.btnUpdateCourse.click();
        });
        Then("^I should be redirected to course information page successfully", () -> {
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
        });
        And("^Course information is successfully updated with \"([^\"]*)\" and \"([^\"]*)\"$", (String cNum,String cTitle) -> {
            assertEquals("SOFTENG754",cNum);
            assertEquals("Advanced requirement development",cTitle);
        });
    }
}
