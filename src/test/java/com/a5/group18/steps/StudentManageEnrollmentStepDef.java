package com.a5.group18.steps;

import com.a5.group18.pages.MyEnrollmentPage;
import cucumber.api.java8.En;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentManageEnrollmentStepDef implements En {

    private MyEnrollmentPage myEnrollmentPage;

    @Autowired
    private UIGlobalState state;
    public StudentManageEnrollmentStepDef() {


        And("^I am on My Enrollment Page$", () -> {
            state.driver.get(state.url+"/myEnrollment");
        });
        When("^I click the text WAITLISTED$", () -> {
            state.wait.until(ExpectedConditions.titleIs("My Enrollment"));
            myEnrollmentPage = new MyEnrollmentPage(state.driver);
            myEnrollmentPage.waitlistLink.click();
        });
        Then("^I should be able to see there is (\\d+) student in front of me in the waiting list$", (Integer studentNum) -> {
            state.wait.until(ExpectedConditions.visibilityOf(myEnrollmentPage.modalContainer));
            Assertions.assertTrue(myEnrollmentPage.modalMsg.getText().contains(studentNum.toString()));
        });
        But("^I can not see the name of the student in front of me$", () -> {
            Assertions.assertFalse(myEnrollmentPage.modalMsg.getText().contains("allen"));
        });


        When("^I click the drop button of course SOFTENG702$", () -> {
            WebElement dropbtn702 = state.driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td[4]/button"));
            state.wait.until(ExpectedConditions.elementToBeClickable(dropbtn702));
            dropbtn702.click();
        });
        And("^I click the confirm button in the modal window$", () -> {
            WebElement confirmBtn = state.driver.findElement(By.id("confirmDrop"));
            state.wait.until(ExpectedConditions.visibilityOf(confirmBtn));
            confirmBtn.click();
        });
        Then("^I should be able to notify the course is dropped successfully$", () -> {
            state.wait.until(ExpectedConditions.alertIsPresent());
            String msg =  state.driver.switchTo().alert().getText();
            Assertions.assertTrue(msg.contains("Succeed"));
        });
    }
}
