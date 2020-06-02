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
        When("^I click <CourseNumber> in my enrollment list$", () -> {
        });
    }
}
