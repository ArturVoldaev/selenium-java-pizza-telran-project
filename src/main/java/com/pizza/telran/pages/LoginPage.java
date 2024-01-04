package com.pizza.telran.pages;

import com.pizza.telran.data.AccessConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='login_title']")
    WebElement loginPageTitle;

    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameInput;

    @FindBy(xpath = " //input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = " //input[@value='Login']")
    WebElement loginButton;

    @FindBy(css = ".login_error")
    WebElement logValidation;

    public LoginPage loginWithBaseUserAccess() {
        fillField(AccessConstant.BASE_USER, userNameInput);
        fillField(AccessConstant.BASE_PASSWORD, passwordInput);
        clickOnElement(loginButton);
        return this;
    }

    public LoginPage loginWithBaseAdminAccess() {
        fillField(AccessConstant.BASE_ADMIN, userNameInput);
        fillField(AccessConstant.BASE_PASSWORD, passwordInput);
        clickOnElement(loginButton);
        return this;
    }

    public LoginPage loginWithFakeLogin() {
        fillField(AccessConstant.RANDOM_USER, userNameInput);
        fillField(AccessConstant.BASE_PASSWORD, passwordInput);
        clickOnElement(loginButton);
        return this;
    }

    public String getValidationText() {
        return logValidation.getText();
    }

    public String getLoginPageTitle() {
        return loginPageTitle.getText();
    }
}
