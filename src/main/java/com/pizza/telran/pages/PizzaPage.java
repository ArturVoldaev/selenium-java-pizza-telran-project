package com.pizza.telran.pages;

import org.openqa.selenium.WebDriver;


public class PizzaPage extends BasePage {
    public PizzaPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRandomPizza(int numberOfElem) {
        clickOnElement(findActionButton(numberOfElem, "Cafe"));
    }

    public PizzaPage clickOnCreateNewPizza() {
        clickOnElement(new BasePage(driver).createNewButton);
        return this;
    }

}
