package com.pizza.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CafeListPage extends BasePage {
    public CafeListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='New']")
    WebElement createNewCafe;


    public Boolean isButtonNewVisible() {
        return createNewCafe.isDisplayed();
    }

}
