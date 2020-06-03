package com.a5.group18.steps;

import com.a5.group18.pages.AdminDashboard;
import com.a5.group18.pages.ManageConcessionPage;
import com.a5.group18.pages.ProcessConcessionPage;
import com.a5.group18.pages.StdDashboardPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentUpdateNotificationStepDef implements En {

    private StdDashboardPage studentDashPage;

    @Autowired
    private UIGlobalState state;
    public StudentUpdateNotificationStepDef() {
        When("^I click update notification button$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Student Dashboard"));
            studentDashPage = new StdDashboardPage(state.driver);
            studentDashPage.btnUpdateNotification.click();
        });

        And("^I select email as the preferred notification method$", () -> {
            state.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notificationModal")));
            Select drpMethods = new Select(state.driver.findElement(By.id("notificationMethods")));
            drpMethods.selectByVisibleText("Email");
        });

        And("^I click save button$", () -> {
            state.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSaveNotificationChanges")));
            studentDashPage.btnSaveNotificationChanges.click();
        });

        Then("^I should see a green banner saying preference saved$", () -> {
            Assert.assertTrue(state.driver.getPageSource().contains("Notification preferences has been updated."));
        });
    }
}
