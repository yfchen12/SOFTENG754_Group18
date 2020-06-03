package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CourseInformationPage {
    private WebDriver driver;

    public CourseInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "coursenum")
    public WebElement coursenum;

    @FindBy(id = "btnDownloadCourse")
    public WebElement btnDownloadCourse;

    @FindBy(id = "ttype")
    public WebElement ttype;

    @FindBy(id = "ttime")
    public WebElement ttime;

    @FindBy(id = "comp1")
    public WebElement comp1;

    @FindBy(id = "comp2")
    public WebElement comp2;

    @FindBy(id = "comp3")
    public WebElement comp3;

    @FindBy(id = "valueList")
    public WebElement valueList;

    @FindBy(id = "coursePre")
    public WebElement coursePre;

    @FindBy(id = "teacherList")
    public WebElement teacherList;

    @FindBy(id = "ttList")
    public List<WebElement> ttList;

    @FindBy(id = "prereList")
    public List<WebElement> prereList;

}
