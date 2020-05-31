package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class SearchResultPage {

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBys({
            @FindBy(className = "SOFTENG701"),
            @FindBy(id="btnAddToCart")
    })
    public WebElement btnAddToCart;

    @FindBy(id = "btnCart")
    public WebElement btnCart;

    @FindBy(id = "myModal")
    public WebElement alert;

}
