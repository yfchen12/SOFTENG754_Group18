package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageConcessionPage {
    private WebDriver driver;

    public ManageConcessionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dateChange")
    public WebElement dateChange;

    @FindBy(id = "concessionCriteria")
    public WebElement concessionCriteria;

    @FindBy(id = "btnSaveChanges")
    public WebElement btnSaveChanges;

    @FindBy(id = "btnProcessConcession")
    public WebElement btnProcessConcession;
}
