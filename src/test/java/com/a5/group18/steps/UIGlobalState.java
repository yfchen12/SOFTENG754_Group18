package com.a5.group18.steps;

import com.a5.group18.pages.LoginSSOPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Component
public class UIGlobalState {

    protected WebDriver driver;
    protected WebDriverWait wait;
    @Value("${spring.app.url}")
    protected String url;
}
