package com.pizza.telran.pages;

import org.openqa.selenium.WebDriver;

public class CafeListPage extends BasePage {
    public CafeListPage(WebDriver driver) {
        super(driver);
    }
    public Boolean isButtonNewVisible() {
        return new BasePage(driver).createNewButton().isDisplayed();
    }
    public CafeListPage clickOnCreateNewCafeButton() {
        clickOnElement(new BasePage(driver).createNewButton());
        return this;
    }
}
