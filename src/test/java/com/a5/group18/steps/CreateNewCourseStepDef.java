package com.a5.group18.steps;


import com.a5.group18.pages.AddNewCoursePage;
import com.a5.group18.pages.AdminDashboard;
import com.a5.group18.pages.CourseManagePage;
import cucumber.api.java8.En;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateNewCourseStepDef implements En {
    private AdminDashboard adminDashPage;
    private AddNewCoursePage addNewCoursePage;
    private CourseManagePage courseManagePage;
    @Autowired
    private UIGlobalState state;

    public CreateNewCourseStepDef() {

        When("^I click create new course button from course manage page$", () -> {
            adminDashPage = new AdminDashboard(state.driver);
            addNewCoursePage = new AddNewCoursePage(state.driver);
            adminDashPage.btnUpdateCourse.click();
            state.wait.until(ExpectedConditions.titleIs("Course Manage"));
            courseManagePage = new CourseManagePage(state.driver);
            courseManagePage.btnAddNewCourse.click();

        });
        Then("^I should be redirected to create course information page$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Add New Course"));
        });
        When("^I finished all the mandatory information$", () -> {
            addNewCoursePage.coursenum.sendKeys("SOFTENG754");
            addNewCoursePage.coursetitle.sendKeys("Advanced requirement development");
            addNewCoursePage.courseshedule.sendKeys("Wednesday 3:00-4:00");
            addNewCoursePage.coutline.sendKeys("Learn how to elicit requirements from customers/users, write requirement specification and perform requirements analysis. Focus on the problem, not the solution.");
            addNewCoursePage.tdtype.sendKeys("PotentialCareer");
            addNewCoursePage.ttime.sendKeys("20190506");
            addNewCoursePage.company1.sendKeys("Xero");
            addNewCoursePage.company2.sendKeys("Microsoft");
            addNewCoursePage.company3.sendKeys("Google");
            addNewCoursePage.cpre.sendKeys("SOFTENG201");
            addNewCoursePage.tname.sendKeys("Kelly Blincoe");
            addNewCoursePage.temail.sendKeys("Kelly.B@auckland.ac.nz");
            addNewCoursePage.tinstruction.sendKeys("Lady from American");
            addNewCoursePage.cstatus.sendKeys("NotAvailable");
            addNewCoursePage.ccapacity.sendKeys("150");
            addNewCoursePage.ccampus.sendKeys("CityCampus");
        });
        And("^I click submit button$", () -> {
            addNewCoursePage.btnAddNewCourse.click();
        });
        Then("^I should be redirected to course information page successful$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
        });
    }
}
