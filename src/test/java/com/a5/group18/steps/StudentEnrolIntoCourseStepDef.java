package com.a5.group18.steps;

import com.a5.group18.pages.CartPage;
import cucumber.api.java8.En;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentEnrolIntoCourseStepDef implements En {

    private CartPage cartPage;

    @Autowired
    private UIGlobalState state;

    public StudentEnrolIntoCourseStepDef() {
        Given("^I am on cart page$", () -> {
            cartPage = new CartPage(state.driver);
            state.driver.get(state.url + "/cart");
        });

        When("^I click the Enrol button of course \"([^\"]*)\"$", (String couresNum) -> {
            state.wait.until(ExpectedConditions.visibilityOf(cartPage.se705DropBtn));
            switch (couresNum) {
                case "SOFTENG705":
                    cartPage.se705DropBtn.click();
                    break;
                case "SOFTENG753":
                    cartPage.se753DropBtn.click();
            }
        });
        And("^I click the confirm button in the modal$", () -> {
            state.wait.until(ExpectedConditions.visibilityOf(cartPage.btnConfirmEnrol));
            cartPage.btnConfirmEnrol.click();
        });
        Then("^I should be informed that I enrolled into the course successfully$", () -> {
            String message = state.driver.switchTo().alert().getText();
            Assertions.assertTrue(message.contains("SUCCESS"));
        });
        Then("^I should be informed that I the people in the waiting list is (\\d+);$", (Integer size) -> {
            String message = state.driver.switchTo().alert().getText();
            Assertions.assertTrue(message.contains("waiting list") && message.contains(size.toString()));
        });

    }
}

