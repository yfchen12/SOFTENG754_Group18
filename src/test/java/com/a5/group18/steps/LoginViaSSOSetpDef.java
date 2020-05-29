package com.a5.group18.steps;

import com.a5.group18.hook.CukeHook;
import com.a5.group18.pages.IndexPage;
import com.a5.group18.pages.LoginSSOPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class LoginViaSSOSetpDef implements En {

    private WebDriver driver;
    private IndexPage indexPage;
    private LoginSSOPage loginSSOPage;
    @Autowired CukeHook cukeHook;
    @Value("${spring.app.url}")
    private String url;

    public LoginViaSSOSetpDef() {
        Given("^open UoA course enrollment website$", () -> {
            driver = cukeHook.getWebDriver();
            indexPage = new IndexPage(driver);
            loginSSOPage = new LoginSSOPage(driver);
            driver.get(url);
        });

        When("^I click login via SSO button$", () -> indexPage.btnLogin.click());

        Then("^I should be redirected to UoA SSO page$", () -> Assert.assertEquals("UoA-SSO", driver.getTitle()));

        When("^I enter my user credentials (.*) and (.*)$", (String username, String password) -> {
            loginSSOPage.username.sendKeys(username);
            loginSSOPage.password.sendKeys(password);
        });

        And("^I click login button$", () -> loginSSOPage.btnLogin.click());

        Then("^I should be login to dashboard page successful", () -> Assert.assertEquals("Admin Dashboard", driver.getTitle()));

        Then("^I should be login to student dashboard page successful$", () -> Assert.assertEquals("Student Dashboard", driver.getTitle()));
    }
}
