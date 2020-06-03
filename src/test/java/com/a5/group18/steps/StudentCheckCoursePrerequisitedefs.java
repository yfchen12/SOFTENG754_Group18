package com.a5.group18.steps;

import com.a5.group18.pages.CourseInformationPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentCheckCoursePrerequisitedefs implements En {
    @Autowired
    private UIGlobalState state;

    private CourseInformationPage courseInformationPage;
    public StudentCheckCoursePrerequisitedefs() {
        Then("^I should be able to see the course prerequisite$", () -> {
            courseInformationPage = new CourseInformationPage(state.driver);
            WebElement pre = null;
            for (int i=0; i<courseInformationPage.prereList.size(); i++)
            {
                if ("SOFTENG101".contains(courseInformationPage.prereList.get(i).getText())){
                    pre = courseInformationPage.prereList.get(i);
                }

            }
            Assert.assertNotNull(pre);
        });
        And("^I should be able to redirected to course information through prerequisite course name$", () -> {
            //state.driver.findElement(By.linkText("SOFTENG101")).click();
            for (int i=0; i<courseInformationPage.prereList.size(); i++)
            {
                if ("SOFTENG101".contains(courseInformationPage.prereList.get(i).getText())){
                    courseInformationPage.prereList.get(i).click();
                }

            }

            Thread.sleep(1000);
            state.wait.until(ExpectedConditions.titleIs("Course Information"));
        });
    }
}
