package com.a5.group18.steps;

import com.a5.group18.pages.CartPage;
import com.a5.group18.pages.SearchCoursePage;
import com.a5.group18.pages.SearchResultPage;
import com.a5.group18.pages.StdDashboardPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class CartManagementStepDef implements En {

    private StdDashboardPage stdDashPage;
    private SearchCoursePage searCoursePage;
    private SearchResultPage searchResultPage;
    private CartPage cartPage;
    private String desiredCourse;
    @Autowired
    private UIGlobalState state;

    public CartManagementStepDef() {
        Given("^I found my desired course (.*) from search result$", (String course) -> {
            stdDashPage = new StdDashboardPage(state.driver);
            searCoursePage = new SearchCoursePage(state.driver);
            searchResultPage = new SearchResultPage(state.driver);
            cartPage = new CartPage(state.driver);
            stdDashPage.btnSearch.click();
            searCoursePage.btnSearch.click();
            desiredCourse = course;
        });
        When("^I click Add To Cart button$", () -> {
            searchResultPage.btnAddToCart.click();
            state.wait.until(ExpectedConditions.visibilityOf(searchResultPage.alert));
            searchResultPage.alert.click();
            searchResultPage.btnCart.click();
        });
        Then("^the course should be added to cart successfully$", () -> {
            Assert.assertEquals("Enrollment Cart", cartPage.strTitle.getText());
            Assert.assertTrue(state.driver.getPageSource().contains(desiredCourse));
        });
    }
}
