package com.a5.group18.steps;

import com.a5.group18.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentCheckCourseInformationStepdefs implements En {
    private CartPage cartPage;
    private StdDashboardPage stdDashboardPage;
    private CourseInformationPage courseInformationPage;
    private MyEnrollmentPage myEnrollmentPage;
    private SearchResultPage searchResultPage;
    private SearchCoursePage searchCoursePage;
    @Autowired
    private UIGlobalState state;
    public StudentCheckCourseInformationStepdefs() {
        And("^I am in enrollment cart page$", () -> {
            stdDashboardPage = new StdDashboardPage(state.driver);
            stdDashboardPage.btnCart.click();
            cartPage = new CartPage(state.driver);
            state.wait.until(ExpectedConditions.titleIs("Enrollment Cart"));

        });

        When("^I click \"([^\"]*)\" in enroll cart list$", (String courseNum) -> {
            state.driver.findElement(By.linkText(courseNum)).click();
        });
        Then("^I should be redirected to \"([^\"]*)\" information page$", (String courseNum) -> {
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
            courseInformationPage = new CourseInformationPage(state.driver);
            Assert.assertEquals(courseNum, courseInformationPage.coursenum.getText());
        });
        When("^I click \"([^\"]*)\" in my enrollment list$", (String courseNum) -> {
            state.driver.findElement(By.linkText(courseNum)).click();
        });
        And("^I am in my enrollment page$", () -> {
            stdDashboardPage = new StdDashboardPage(state.driver);
            stdDashboardPage.btnMyEnrollment.click();
            myEnrollmentPage = new MyEnrollmentPage(state.driver);
            state.wait.until(ExpectedConditions.titleIs("My Enrollment"));
        });
        And("^I am in search result page$", () -> {
            stdDashboardPage = new StdDashboardPage(state.driver);
            stdDashboardPage.btnSearch.click();
            state.wait.until(ExpectedConditions.titleIs("Search Course"));
            searchCoursePage = new SearchCoursePage(state.driver);
            searchCoursePage.btnSearch.click();
            searchResultPage = new SearchResultPage(state.driver);
            state.wait.until(ExpectedConditions.titleIs("Search Result"));
        });
        When("^I click \"([^\"]*)\" in the result list$", (String courseNum) -> {
            state.driver.findElement(By.linkText(courseNum)).click();
        });
        And("^I am in course information page$", () -> {
            stdDashboardPage = new StdDashboardPage(state.driver);
            stdDashboardPage.btnCart.click();
            cartPage = new CartPage(state.driver);
            state.wait.until(ExpectedConditions.titleIs("Enrollment Cart"));
            state.driver.findElement(By.linkText("SOFTENG701")).click();
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
        });
        When("^I click \"([^\"]*)\" list in the page$", (String teacher) -> {
            Thread.sleep(1000);

            state.driver.findElement(By.linkText(teacher)).click();
        });
        Then("^I should be redirected to teacher profile page$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Teacher Information"));
        });
        And("^I am in \"([^\"]*)\" course information page$", (String coursenum) -> {
            stdDashboardPage = new StdDashboardPage(state.driver);
            stdDashboardPage.btnCart.click();
            cartPage = new CartPage(state.driver);
            state.wait.until(ExpectedConditions.titleIs("Enrollment Cart"));
            state.driver.findElement(By.linkText(coursenum)).click();
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
        });
        When("^I click download in the bottom of the page$", () -> {
            Thread.sleep(1000);
            courseInformationPage= new CourseInformationPage(state.driver);
            courseInformationPage.btnDownloadCourse.click();
        });
        Then("^I should be able to download \"([^\"]*)\"\\.pdf$", (String course) -> {
            //right now do not have one good idea for different platform
        });
    }
}
