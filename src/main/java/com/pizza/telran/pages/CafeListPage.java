package com.pizza.telran.pages;

import org.openqa.selenium.WebDriver;

public class CafeListPage extends BasePage {
    public CafeListPage(WebDriver driver) {
        super(driver);
    }
    public Boolean isButtonNewVisible() {
        return new BasePage(driver).getCreateNewButton().isDisplayed();
    }
    public CafeListPage clickOnCreateNewCafeButton() {
        clickOnElement(new BasePage(driver).getCreateNewButton());
        return this;
    }
}
