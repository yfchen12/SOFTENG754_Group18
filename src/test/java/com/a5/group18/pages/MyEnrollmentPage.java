package com.a5.group18.pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath="//*[@id=\"modalCenter\"]/div")
    public WebElement modal;

    @FindBy(xpath="/html/body/div[2]/table/tbody/tr[2]/td[3]/a")
    public WebElement waitlistLink;

    @FindBy(xpath = "/html/body/div[3]")
    public WebElement modalContainer;

    @FindBy(id="modal-waitlist")
    public WebElement modalMsg;

    @FindBy(id="SOFTENG701dropBtn")
    public WebElement dropbtn701;

    @FindBy(id="SOFTENG702dropBtn")
    public WebElement dropbtn702;

    @FindBy(id="SOFTENG704dropBtn")
    public WebElement dropbtn704;
}
