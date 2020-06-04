package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcessionSubmitPage {
    private WebDriver driver;

    public ConcessionSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "reason")
    public WebElement reason;

    @FindBy(id = "justification")
    public WebElement justification;

    @FindBy(id = "attachment")
    public WebElement file;

    @FindBy(id = "submitBtn")
    public WebElement submitBtn;

}
