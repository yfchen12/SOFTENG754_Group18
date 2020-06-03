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
            for (int i=0; i<cartPage.courseNum.size(); i++)
            {
                if (courseNum.contains(cartPage.courseNum.get(i).getText())){
                    cartPage.courseNum.get(i).click();
                }

            }
        });
        Then("^I should be redirected to \"([^\"]*)\" information page$", (String courseNum) -> {
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
            courseInformationPage = new CourseInformationPage(state.driver);
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
            for (int i=0; i<searchResultPage.courseNum.size(); i++)
            {
                if (courseNum.contains(searchResultPage.courseNum.get(i).getText())){
                    searchResultPage.courseNum.get(i).click();
                }

            }

        });
        And("^I am in course information page$", () -> {
            stdDashboardPage = new StdDashboardPage(state.driver);
            stdDashboardPage.btnCart.click();
            cartPage = new CartPage(state.driver);
            state.wait.until(ExpectedConditions.titleIs("Enrollment Cart"));

            cartPage.courseNum.get(0).click();
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
        });
        When("^I click \"([^\"]*)\" list in the page$", (String teacher) -> {
            Thread.sleep(1000);
            courseInformationPage = new CourseInformationPage(state.driver);
            for (int i=0; i<courseInformationPage.ttList.size(); i++) {
                if (teacher.contains(courseInformationPage.ttList.get(i).getText())) {
                    courseInformationPage.ttList.get(i).click();
                }
            }
        });
        Then("^I should be redirected to teacher profile page$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Teacher Information"));
        });
        And("^I am in \"([^\"]*)\" course information page$", (String coursenum) -> {
            stdDashboardPage = new StdDashboardPage(state.driver);
            stdDashboardPage.btnCart.click();
            cartPage = new CartPage(state.driver);
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
            courseInformationPage= new CourseInformationPage(state.driver);
            courseInformationPage.btnDownloadCourse.click();
        });
        Then("^I should be able to download \"([^\"]*)\"\\.pdf$", (String course) -> {
            //right now do not have one good idea for different platform
        });

        When("^I click \"([^\"]*)\" list in the page$", (String teacher) -> {

        });
    }
}
