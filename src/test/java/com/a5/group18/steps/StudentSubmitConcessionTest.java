package com.a5.group18.steps;

import com.a5.group18.pages.CartPage;
import com.a5.group18.pages.ConcessionSubmitPage;
import com.a5.group18.pages.ConcessionInfoPage;
import cucumber.api.java8.En;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;


public class StudentSubmitConcessionTest implements En {
    CartPage cartPage;
    ConcessionInfoPage concessionInfoPage;
    ConcessionSubmitPage concessionSubmitPage;
    @Autowired
    private UIGlobalState state;

    public StudentSubmitConcessionTest() {
        And("^I have started to submit a concession for course SOFTENG752$", () -> {
            cartPage = new CartPage(state.driver);
            concessionInfoPage = new ConcessionInfoPage(state.driver);
            concessionSubmitPage = new ConcessionSubmitPage(state.driver);
            state.wait.until(ExpectedConditions.visibilityOf(cartPage.btnCart));
            cartPage.btnCart.click();
            state.wait.until(ExpectedConditions.visibilityOf(cartPage.se752DropBtn));
            cartPage.se752DropBtn.click();
            state.wait.until(ExpectedConditions.visibilityOf(cartPage.btnConfirmEnrol));
            cartPage.btnConfirmEnrol.click();
        });
        And("^I navigate to the concession submission page$", () -> {
            state.wait.until(ExpectedConditions.visibilityOf(concessionInfoPage.startBtn));
            concessionInfoPage.startBtn.click();
        });
        When("^I fill in the concession form with the \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$", (String reason, String justification, String fileUploadPath) -> {
            state.wait.until(ExpectedConditions.visibilityOf(concessionSubmitPage.submitBtn));
            concessionSubmitPage.reason.sendKeys(reason);
            concessionSubmitPage.justification.sendKeys(justification);
        });
        And("^I click the submit button$", () -> {
            concessionSubmitPage.submitBtn.click();
        });

        Then("^I should be notified the concession was submitted$", () -> {
            String msg = state.driver.switchTo().alert().getText();
            Assertions.assertTrue(msg.contains("Success"));
        });

    }
}
