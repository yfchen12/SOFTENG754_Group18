package com.a5.group18.steps;

import com.a5.group18.pages.*;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ManageConcessionStepDef implements En {

    private AdminDashboard adminDashPage;
    private ManageConcessionPage manageConcessionPage;
    private ProcessConcessionPage processConcessionPage;

    @Autowired
    private UIGlobalState state;
    public ManageConcessionStepDef() {
        Given("^I click manage concession from (.*) page$", (String pageTitle) -> {
            state.wait.until(ExpectedConditions.titleIs(pageTitle));
            adminDashPage = new AdminDashboard(state.driver);
            manageConcessionPage = new ManageConcessionPage(state.driver);
            adminDashPage.btnManageConcession.click();
        });

        When("^I click edit button for the most recent concession open date$", () -> {
            String editPath = "//*[@id=\"editOpenDate\"]";

            WebElement editButton = state.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(editPath)));
            editButton.click();
        });

        And("^I change the date to tomorrow$", () -> {
            state.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateChange")));
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Date tomorrow = calendar.getTime();
            // This is to convert Date to String
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            manageConcessionPage.dateChange.sendKeys(sdf.format(tomorrow));
        });

        And("^I click confirm date change button$", () -> {
            WebElement btnConfirm = state.wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmDateChange")));
            btnConfirm.click();
        });

        Then("^the most recent concession open date should be tomorrow$", () -> {
            state.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dateChangeModal")));
            String recentDatePath = "//*[@id=\"openDate\"]";

            WebElement baseTable = state.driver.findElement(By.tagName("table"));
            WebElement recentDateWE = baseTable.findElement(By.xpath(recentDatePath));
            String recentDate = recentDateWE.getText();

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Date tomorrow = calendar.getTime();
            // This is to convert Date to String
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Assert.assertEquals(recentDate, sdf.format(tomorrow));
        });
    }
}
