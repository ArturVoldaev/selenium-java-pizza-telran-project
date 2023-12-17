package com.pizza.telran.pages;

import com.pizza.telran.data.CafeTableConstant;
import com.pizza.telran.data.GenerateRandomData;
import com.pizza.telran.data.PizzaTableConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PizzaPage extends BasePage {
    public PizzaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "tr")
    List<WebElement> pizzaList;

    @FindBy(tagName = "th")
    List<WebElement> pizzaTableHeading;

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

//    public String getDataFromTable(String pizzaParam, List<WebElement> row, List<WebElement> unit, int numberOfRow) {
//        WebElement element = unit.get(numberOfRow);
//        List<WebElement> children = element.findElements(By.tagName("td"));
//        //System.out.println(children.get(findNumberOfColumn(pizzaParam)).getText());
//        return children.get(findNumberOfColumn(pizzaParam, row)).getText();
//    }

    public PizzaPage fillGlobalData() {
        CafeTableConstant.MY_CAFE = getDataFromTable(
                PizzaTableConstant.PIZZA_COLUM_CAFE,
                pizzaTableHeading,
                pizzaList,
                generateRandomRow(getRowAmount(pizzaList)));
        return this;
    }
}
