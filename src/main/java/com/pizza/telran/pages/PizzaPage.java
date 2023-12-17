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

    @FindBy(tagName = "tbody")
    WebElement pizzaTable;

    @FindBy(tagName = "th")
    List<WebElement> pizzaTableHeading;

    @FindBy(xpath = "(//button[@type='submit'][normalize-space()='Cafe'])")
    String pizzaButton;

    public int findNumberOfColumn(String needData) {
        int numberOfColumn = 0;
        for (int i = 0; i < pizzaTableHeading.size(); i++) {
            WebElement element = pizzaTableHeading.get(i);
            if (element.getText().equals(needData)) {
                numberOfColumn = i;
                break;
            }
        }
        return numberOfColumn;
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

    public int getPizzaAmount() {
        return pizzaList.size();
    }

    public int generatePizzaNumber() {
        return PizzaTableConstant.PIZZA_NUMBER = new GenerateRandomData().generateRandomNumberInRange(1, getPizzaAmount());
    }

    public String getPizzaData(String pizzaParam) {
        WebElement element = pizzaList.get(generatePizzaNumber());
        List<WebElement> children = element.findElements(By.tagName("td"));
        //System.out.println(children.get(findNumberOfColumn(pizzaParam)).getText());
        return children.get(findNumberOfColumn(pizzaParam)).getText();
    }

    public PizzaPage fillGlobalData() {
        CafeTableConstant.MY_CAFE = getPizzaData(PizzaTableConstant.PIZZA_COLUM_CAFE);
        return this;
    }

}
