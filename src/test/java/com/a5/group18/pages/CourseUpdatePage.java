package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseUpdatePage {
    private WebDriver driver;

    public CourseUpdatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "coursenum")
    public WebElement coursenum;

    @FindBy(id = "coursetitle")
    public WebElement coursetitle;

    @FindBy(id = "courseshedule")
    public WebElement courseshedule;

    @FindBy(id = "coutline")
    public WebElement coutline;

    @FindBy(id = "cvalue")
    public WebElement cvalue;

    @FindBy(id = "cpre")
    public WebElement cpre;

    @FindBy(id = "tteam")
    public WebElement tteam;

    @FindBy(id = "cstatus")
    public WebElement cstatus;

    @FindBy(id = "ccapacity")
    public WebElement ccapacity;

    @FindBy(id = "ccampus")
    public WebElement ccampus;

    @FindBy(id = "btnUpdateCourse")
    public WebElement btnUpdateCourse;
}
