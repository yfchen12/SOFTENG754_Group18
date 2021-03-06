package com.a5.group18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

import java.util.List;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "page_title")
    public WebElement strTitle;

    @FindBy(id = "myModal")
    public WebElement alert;

    @FindBy(id = "confirmModal")
    public WebElement confirmModal;

    @FindBy(id = "btnConfirm")
    public WebElement btnConfirm;

    @FindBy(id = "btnDelete")
    public WebElement btnDelete;

    @FindBy(id = "courseLink")
    public List<WebElement> courseNum;

    @FindBy(id = "SOFTENG705btnEnrol")
    public WebElement se705DropBtn;

    @FindBy(id = "btnConfirmEnrol")
    public WebElement btnConfirmEnrol;

    @FindBy(id = "SOFTENG753btnEnrol")
    public WebElement se753DropBtn;

    @FindBy(id = "SOFTENG752btnEnrol")
    public WebElement se752DropBtn;

    @FindBy(id ="btnCart")
    public WebElement btnCart;
}
