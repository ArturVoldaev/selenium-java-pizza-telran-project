package com.pizza.telran.pages;

import com.pizza.telran.data.AccessConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='login_title']")
    WebElement logInPageTitle;

    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameInput;

    @FindBy(xpath = " //input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = " //input[@value='Login']")
    WebElement logInButton;

    @FindBy(css = ".login_error")
    WebElement logValidation;

    public LogInPage logInWithBaseUserAccess() {
        fillField(AccessConstant.BASE_USER, userNameInput);
        fillField(AccessConstant.BASE_PASSWORD, passwordInput);
        clickOnElement(logInButton);
        return this;
    }

    public LogInPage logInWithBaseAdminAccess() {
        fillField(AccessConstant.BASE_ADMIN, userNameInput);
        fillField(AccessConstant.BASE_PASSWORD, passwordInput);
        clickOnElement(logInButton);
        return this;
    }

    public LogInPage logInWithFakeLogin() {
        fillField(AccessConstant.RANDOM_USER, userNameInput);
        fillField(AccessConstant.BASE_PASSWORD, passwordInput);
        clickOnElement(logInButton);
        return this;
    }

    public String getValidationText() {
        return logValidation.getText();
    }

    public String getLogInPageTitle() {
        return logInPageTitle.getText();
    }
}
