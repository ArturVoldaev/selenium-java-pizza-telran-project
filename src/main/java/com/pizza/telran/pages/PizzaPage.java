package com.pizza.telran.pages;

import com.pizza.telran.data.CafeTableConstant;
import com.pizza.telran.data.PizzaTableConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PizzaPage extends BasePage {
    public PizzaPage(WebDriver driver) {
        super(driver);
    }
    public String randomNumberOfPizzas() {
        return "["+ PizzaTableConstant.PIZZA_NUMBER +"]";
    }
    public WebElement randomPizzaButton() {
        return driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Cafe'])"+ randomNumberOfPizzas()));
    }
    public void clickOnRandomPizza() {
        fillGlobalData();
        clickOnElement(randomPizzaButton());
    }
    public PizzaPage fillGlobalData() {
        CafeTableConstant.MY_CAFE = getDataFromTable(
                PizzaTableConstant.PIZZA_COLUM_CAFE,
                new BasePage(driver).tableHeading,
                new BasePage(driver).rows,
                generateRandomRow(getRowAmount( new BasePage(driver).rows)));
        return this;
    }
    public PizzaPage clickOnCreateNewPizza() {
        clickOnElement(new BasePage(driver).createNewButton());
        return this;
    }
}
