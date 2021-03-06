package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class SearchCoursePage {
    private WebDriver driver;

    public SearchCoursePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "courseNbr")
    public WebElement inputCourseNbr;

    @FindBy(id = "courseTitle")
    public WebElement inputCourseTitle;

    @FindBy(id = "search")
    public WebElement btnSearch;
}
