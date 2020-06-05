package com.a5.group18;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber/cucumber.json",
                "junit:target/cucumber/cucumber.xml",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "rerun:target/rerun.txt",
                "de.monochromata.cucumber.report.PrettyReports:target/cucumber",
        },
        glue = {"com.a5.group18.steps", "com.a5.group18.hook"},
        junit = {"--step-notifications"},
        monochrome = true
        , tags = {"not @deprecated"}
)
public class Group18ApplicationTests {
}
