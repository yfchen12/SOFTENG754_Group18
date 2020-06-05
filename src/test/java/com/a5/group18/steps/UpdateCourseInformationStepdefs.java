package com.a5.group18.steps;

import com.a5.group18.pages.AdminDashboard;
import com.a5.group18.pages.CourseManagePage;
import com.a5.group18.pages.CourseUpdatePage;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

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
        And("^Redirected to courses list page$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Course Manage"));
        });
        Then("^I press edit button in the list$", () -> {
            courseManagePage.manageAction.get(1).click();
        });
        And("^I should be redirected to courses edit page$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Edit Course"));
        });

        Given("^I update the course status to unavailable$", () -> {
            Select drpStatus = new Select(state.driver.findElement(By.id("cstatus")));
            drpStatus.selectByValue("NOT_AVAILABLE");
            courseUpdatePage.coutline.sendKeys("Learn how to elicit requirements from customers/users, write requirement specification and perform requirements analysis. Focus on the problem, not the solution.");
            courseUpdatePage.cvalue.sendKeys("Vocational skills by Xero 2020 March 3rd");
            courseUpdatePage.tteam.sendKeys("Kelly Blincoe");
        });
        When("^I click submit update button$", () -> {
            WebElement btnSubmit = state.wait.until(ExpectedConditions.elementToBeClickable(By.id("btnUpdateCourse")));
            btnSubmit.click();
        });
        Given("^I update the course title and its details$", () -> {
            courseUpdatePage.coursenum.sendKeys("SOFTENG754");
            courseUpdatePage.coursetitle.sendKeys("Advanced requirement development");
            courseUpdatePage.courseshedule.sendKeys("Wednesday 3:00-4:00");
            courseUpdatePage.coutline.sendKeys("Learn how to elicit requirements from customers/users, write requirement specification and perform requirements analysis. Focus on the problem, not the solution.");
            courseUpdatePage.cvalue.sendKeys("Vocational skills by Xero 2020 March 3rd");
            courseUpdatePage.cpre.sendKeys("SOFTENG201");
            courseUpdatePage.tteam.sendKeys("Kelly Blincoe");

            courseUpdatePage.ccapacity.sendKeys("150");
            courseUpdatePage.ccampus.sendKeys("CityCampus");
        });
        Then("^I should be redirected to course information page successfully", () -> {
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
        });
    }
}
