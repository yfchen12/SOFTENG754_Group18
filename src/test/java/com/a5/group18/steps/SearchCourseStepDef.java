package com.a5.group18.steps;

import com.a5.group18.pages.SearchCoursePage;
import com.a5.group18.pages.StdDashboardPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class SearchCourseStepDef implements En {

    private StdDashboardPage stdDashPage;
    private SearchCoursePage searCoursePage;
    @Autowired
    private UIGlobalState state;

    public SearchCourseStepDef() {

        And("^I click search course button from Student Dashboard page$", () -> {
            stdDashPage = new StdDashboardPage(state.driver);
            searCoursePage = new SearchCoursePage(state.driver);
            stdDashPage.btnSearch.click();
        });
        Given("^I search by \"([^\"]*)\" with value \"([^\"]*)\"$", (String searchBy, String value) -> {
            state.wait.until(ExpectedConditions.titleIs("Search Course"));
            switch (searchBy) {
                case "courseNumber":
                    searCoursePage.inputCourseNbr.sendKeys(value);
                    break;
                case "courseTitle":
                    searCoursePage.inputCourseTitle.sendKeys(value);
                    break;
            }

        });
        When("^I click search button$", () -> searCoursePage.btnSearch.click());

        Then("^the search result should be displayed on Search Result page$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Search Result"));
            Assert.assertTrue(state.driver.getPageSource().contains("SOFTENG701"));
        });

        Given("^I search by course number and course title$", () -> {
            state.wait.until(ExpectedConditions.titleIs("Search Course"));
            searCoursePage.inputCourseNbr.sendKeys("SOFTENG701");
            searCoursePage.inputCourseTitle.sendKeys("OOP Development");
        });

        Given("^I search by course number with incomplete value (.*)$", (String value)
                -> searCoursePage.inputCourseNbr.sendKeys(value));

    }
}
