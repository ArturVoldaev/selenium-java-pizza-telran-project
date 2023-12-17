package com.pizza.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement(WebElement nameOfWebElement) {
        nameOfWebElement.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void fillField(String text, WebElement element) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

}
