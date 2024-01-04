package com.pizza.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CafeMenuPage extends BasePage {
    public CafeMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cafe_name")
    WebElement cafeName;

    public String cafeName() {
        return cafeName.getText();
    }

}
