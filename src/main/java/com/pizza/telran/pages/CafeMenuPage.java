package com.pizza.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CafeMenuPage extends BasePage {
    public CafeMenuPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isRightCafe(String myCafe) {
        return driver.findElement(By.xpath("//p[normalize-space()='"+ myCafe +"']")).isDisplayed();
    }

}
