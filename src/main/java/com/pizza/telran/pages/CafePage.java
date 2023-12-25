package com.pizza.telran.pages;

import org.openqa.selenium.WebDriver;

public class CafePage extends BasePage {
    public CafePage(WebDriver driver) {
        super(driver);
    }
    public Boolean isButtonNewVisible() {
        return new BasePage(driver).getCreateNewButton().isDisplayed();
    }
    public CafePage clickOnCreateNewCafeButton() {
        clickOnElement(new BasePage(driver).getCreateNewButton());
        return this;
    }
}
