package com.a5.group18.steps;

import com.a5.group18.pages.CourseInformationPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentCheckCourseValueStepdefs implements En {
    @Autowired
    private UIGlobalState state;

    private CourseInformationPage courseInformationPage;

    public StudentCheckCourseValueStepdefs() {

        Then("^I should be able to see the course value$", () -> {
            Thread.sleep(2000);

            courseInformationPage = new CourseInformationPage(state.driver);

            Assert.assertTrue(courseInformationPage.ttype.isDisplayed());

        });
        And("^I should be able to see the \"([^\"]*)\" and \"([^\"]*)\" by \"([^\"]*)\"$", (String valueType, String valueLastTime, String company) -> {
            Assert.assertTrue(valueType.contains(courseInformationPage.ttype.getText()));
            Assert.assertTrue(valueLastTime.contains(courseInformationPage.ttime.getText()));
            Assert.assertTrue(company.contains(courseInformationPage.comp1.getText()));
            Assert.assertTrue(company.contains(courseInformationPage.comp2.getText()));
            Assert.assertTrue(company.contains(courseInformationPage.comp3.getText()));
        });
    }
}
