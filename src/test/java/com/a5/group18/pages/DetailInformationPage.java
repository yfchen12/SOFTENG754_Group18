package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class DetailInformationPage {

    public WebDriver driver;

    public DetailInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnAddToCart")
    public WebElement btnAddToCart;

    @FindBy(id = "myModal")
    public WebElement alert;

    @FindBy(id = "btnCart")
    public WebElement btnCart;
}
