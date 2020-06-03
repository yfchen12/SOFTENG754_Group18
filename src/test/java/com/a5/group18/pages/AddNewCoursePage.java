package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCoursePage {
    private WebDriver driver;

    public AddNewCoursePage(WebDriver driver) {
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

    @FindBy(id = "cpre")
    public WebElement cpre;

    @FindBy(id = "ttime")
    public WebElement ttime;

    @FindBy(id = "ttype")
    public WebElement tdtype;

    @FindBy(id = "company1")
    public WebElement company1;

    @FindBy(id = "company2")
    public WebElement company2;

    @FindBy(id = "company3")
    public WebElement company3;

    @FindBy(id = "tname")
    public WebElement tname;

    @FindBy(id = "temail")
    public WebElement temail;

    @FindBy(id = "tinstruction")
    public WebElement tinstruction;

    @FindBy(id = "cstatus")
    public WebElement cstatus;

    @FindBy(id = "ccapacity")
    public WebElement ccapacity;

    @FindBy(id = "ccampus")
    public WebElement ccampus;

    @FindBy(id = "btnAddNewCourse")
    public WebElement btnAddNewCourse;
}
