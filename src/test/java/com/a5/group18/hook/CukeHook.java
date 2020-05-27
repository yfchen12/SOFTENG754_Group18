package com.a5.group18.hook;

import com.a5.group18.util.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by tshi User: shitim Date: 05/07/2019 Time: 10:58 AM To change this template use File |
 * Settings | File Templates.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CukeHook {

    private WebDriver driver;
    @Autowired
    private DriverFactory driverFactory;

    @Before
    public void setup_cucumber_spring_context() {
        // Dummy method so cucumber will recognize this class as glue
        // and use its context configuration.
    }

    @Before(order = 0)
    public void beforeScenario() {
        driver = driverFactory.getLocalWebDriver();
        driver.manage().window().maximize();
    }

    @After
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write(
                        "Current Page title and URL is "
                                + driver.getTitle()
                                + " /// "
                                + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
