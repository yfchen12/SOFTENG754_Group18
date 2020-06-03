package com.a5.group18.steps;

import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentCheckCoursePrerequisitedefs implements En {
    @Autowired
    private UIGlobalState state;
    public StudentCheckCoursePrerequisitedefs() {
        Then("^I should be able to see the course prerequisite$", () -> {
            Assert.assertNotNull(state.driver.findElement(By.linkText("SOFTENG101")));
        });
        And("^I should be able to redirected to course information through prerequisite course name$", () -> {
            state.driver.findElement(By.linkText("SOFTENG101")).click();
            Thread.sleep(1000);
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
        });
    }
}
