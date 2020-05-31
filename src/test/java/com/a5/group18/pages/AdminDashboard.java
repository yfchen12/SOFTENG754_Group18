package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboard {
    private WebDriver driver;

    public AdminDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnAddNewCourse")
    public WebElement btnAddNewCourse;

    @FindBy(id = "btnUpdateCourse")
    public WebElement btnUpdateCourse;
}
