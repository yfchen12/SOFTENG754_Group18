package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class StdDashboardPage {


    private WebDriver driver;

    public StdDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnSearch")
    public WebElement btnSearch;

    @FindBy(id = "btnMyEnroll")
    public WebElement btnMyEnrollment;

    @FindBy(id = "btnLogout")
    public WebElement btnLogout;

    @FindBy(id = "btnCart")
    public WebElement btnCart;
}
