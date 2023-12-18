package com.pizza.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[.='Cafe Pizza']")
    WebElement mainPageH1Title;

    @FindBy(xpath = "//a[.='Home']")
    WebElement headerHomeButton;

    @FindBy(xpath = "//a[.='Cafe']")
    WebElement headerCafeButton;

    @FindBy(css = "a[class='login']")
    WebElement headerLogInButton;

    @FindBy(xpath = "//button[.='Cafes']")
    WebElement bodyCafesButton;

    @FindBy(xpath = "//button[.='Pizzas']")
    WebElement bodyPizzasButton;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitButton;

    public HomePage clickToHeaderButtonHomePage() {
        clickOnElement(headerHomeButton);
        return this;
    }
    public HomePage clickToHeaderButtonCafePage() {
        clickOnElement(headerCafeButton);
        return this;
    }

    public HomePage clickToHeaderButtonLogInPage() {
        clickOnElement(headerLogInButton);
        return this;
    }

    public HomePage clickToBodyButtonCafes() {
        clickOnElement(bodyCafesButton);
        return this;
    }

    public HomePage clickToBodyButtonPizzas() {
        clickOnElement(bodyPizzasButton);
        return this;
    }

    public String getTitleText() {
        return mainPageH1Title.getText();
    }


}
