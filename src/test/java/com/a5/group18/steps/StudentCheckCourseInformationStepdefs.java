package com.a5.group18.steps;

import com.a5.group18.pages.*;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        And("^I am in student dash board page$", () -> {
            stdDashboardPage = new StdDashboardPage(state.driver);
            cartPage = new CartPage(state.driver);
            courseInformationPage = new CourseInformationPage(state.driver);
            myEnrollmentPage = new MyEnrollmentPage(state.driver);
            searchCoursePage = new SearchCoursePage(state.driver);
            searchResultPage = new SearchResultPage(state.driver);
        });

        And("^I am in enrollment cart page$", () -> {
            stdDashboardPage.btnCart.click();
            state.wait.until(ExpectedConditions.titleIs("Enrollment Cart"));
        });
        When("^I click \"([^\"]*)\" in enroll cart list$", (String courseNum) -> {
            for (int i=0; i<cartPage.courseNum.size(); i++)
            {
                if (courseNum.contains(cartPage.courseNum.get(i).getText())){
                    cartPage.courseNum.get(i).click();
                }
            }
        });
        Then("^I should be redirected to \"([^\"]*)\" information page$", (String courseNum) -> {
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
            Assert.assertEquals(courseNum, courseInformationPage.coursenum.getText());
        });
        When("^I click \"([^\"]*)\" in my enrollment list$", (String courseNum) -> {
            for (int i=0; i<myEnrollmentPage.courseNum.size(); i++)
            {
                if (courseNum.contains(myEnrollmentPage.courseNum.get(i).getText())){
                    myEnrollmentPage.courseNum.get(i).click();
                }
            }
        });
        And("^I am in my enrollment page$", () -> {
            stdDashboardPage.btnMyEnrollment.click();
            state.wait.until(ExpectedConditions.titleIs("My Enrollment"));
        });
        And("^I am in search result page$", () -> {
            stdDashboardPage.btnSearch.click();
            state.wait.until(ExpectedConditions.titleIs("Search Course"));
            searchCoursePage.btnSearch.click();
            state.wait.until(ExpectedConditions.titleIs("Search Result"));
        });
        When("^I click \"([^\"]*)\" in the result list$", (String courseNum) -> {
            for (int i=0; i<searchResultPage.courseNum.size(); i++)
            {
                if (courseNum.contains(searchResultPage.courseNum.get(i).getText())){
                    searchResultPage.courseNum.get(i).click();
                }
            }

        });
        And("^I am in course information page$", () -> {
            stdDashboardPage.btnCart.click();
            state.wait.until(ExpectedConditions.titleIs("Enrollment Cart"));
            cartPage.courseNum.get(0).click();
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
        });

        Then("^I should be redirected to teacher profile page$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Teacher Information"));
        });
        And("^I am in \"([^\"]*)\" course information page$", (String coursenum) -> {
            stdDashboardPage.btnCart.click();
            state.wait.until(ExpectedConditions.titleIs("Enrollment Cart"));
            for (int i=0; i<cartPage.courseNum.size(); i++) {
                if (coursenum.contains(cartPage.courseNum.get(i).getText())) {
                    cartPage.courseNum.get(i).click();
                }
            }
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
        });
        When("^I click download in the bottom of the page$", () -> {
            Thread.sleep(1000);
            courseInformationPage.btnDownloadCourse.click();
        });
        Then("^I should be able to download \"([^\"]*)\"\\.pdf$", (String course) -> {
            //right now do not have one good idea for different platform
        });

        When("^I click (.*) in the page$", (String teacher) -> {
            Thread.sleep(500);
            WebElement teacherLink = state.driver.findElement(By.id(teacher.replace(" ", "")));
            ((JavascriptExecutor) state.driver).executeScript("arguments[0].click();", teacherLink);
        });

    }
}
