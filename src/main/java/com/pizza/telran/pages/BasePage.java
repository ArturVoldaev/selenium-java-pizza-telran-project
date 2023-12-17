package com.pizza.telran.pages;

import com.pizza.telran.data.GenerateRandomData;
import com.pizza.telran.data.PizzaTableConstant;
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

    public int findNumberOfColumn(String needData, List<WebElement> elements) {
        int numberOfColumn = 0;
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            if (element.getText().equals(needData)) {
                numberOfColumn = i;
                break;
            }
        }
        return numberOfColumn;
    }
    public int getRowAmount( List<WebElement> rows) {
        return rows.size();
    }

    public int generateRandomRow(int elemAmount) {
        return PizzaTableConstant.PIZZA_NUMBER = new GenerateRandomData().generateRandomNumberInRange(1, elemAmount-1);
    }

    public String getDataFromTable(String pizzaParam, List<WebElement> row, List<WebElement> unit, int numberOfRow) {
        WebElement element = unit.get(numberOfRow);
        List<WebElement> children = element.findElements(By.tagName("td"));
        //System.out.println(children.get(findNumberOfColumn(pizzaParam, row)).getText());
        return children.get(findNumberOfColumn(pizzaParam, row)).getText();
    }
}
