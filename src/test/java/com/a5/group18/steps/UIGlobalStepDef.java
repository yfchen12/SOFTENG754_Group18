package com.a5.group18.steps;

import com.a5.group18.hook.CukeHook;
import com.a5.group18.pages.*;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class UIGlobalStepDef  implements En {

    private IndexPage indexPage;
    private LoginSSOPage loginSSOPage;
    @Autowired
    UIGlobalState state;
    @Autowired
    CukeHook cukeHook;

    public UIGlobalStepDef() {
        Given("^I login as a (.*)$", (String userType) -> {
            state.driver = cukeHook.getWebDriver();
            state.wait = new WebDriverWait(state.driver, 30);
            indexPage = new IndexPage(state.driver);
            loginSSOPage = new LoginSSOPage(state.driver);
            state.driver.get(state.url);
            indexPage.btnLogin.click();
            if (userType.equalsIgnoreCase("student")) {
                loginSSOPage.username.sendKeys("john.smith@uoa.com");
            } else {
                loginSSOPage.username.sendKeys("tim.shi@uoa.com");
            }
            loginSSOPage.password.sendKeys("123");
            loginSSOPage.btnLogin.click();
            if (userType.equalsIgnoreCase("student")) {
                state.wait.until(ExpectedConditions.titleIs("Student Dashboard"));
            } else {
                state.wait.until(ExpectedConditions.titleIs("Admin Dashboard"));
            }
        });
    }
}
