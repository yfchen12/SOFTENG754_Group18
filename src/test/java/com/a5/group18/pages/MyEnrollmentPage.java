package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class MyEnrollmentPage {
    private WebDriver driver;

    public MyEnrollmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBys({
            @FindBy(className = "SOFTENG701"),
            @FindBy(id="enrollStatus")
    })
    public WebElement se701Status;

    @FindBys({
            @FindBy(className = "SOFTENG702"),
            @FindBy(id="enrollStatus")
    })
    public WebElement se702Status;

    @FindBys({
            @FindBy(className = "SOFTENG703"),
            @FindBy(id="enrollStatus")
    })
    public WebElement se703Status;
}