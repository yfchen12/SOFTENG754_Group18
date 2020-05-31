package com.a5.group18.steps;

import com.a5.group18.pages.IndexPage;
import com.a5.group18.pages.StdDashboardPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class LogoutStepDef implements En {

    @Autowired
    UIGlobalState state;
    private StdDashboardPage stdDashPage;

    public LogoutStepDef() {
        When("^I click Logout button$", () -> {
            stdDashPage = new StdDashboardPage(state.driver);
            stdDashPage.btnLogout.click();
        });
        Then("^I should be able to logout successfully$", () -> {
            Assert.assertEquals("UoA Enrollment System", state.driver.getTitle());
        });
    }
}
