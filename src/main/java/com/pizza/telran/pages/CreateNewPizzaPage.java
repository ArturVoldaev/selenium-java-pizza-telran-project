package com.pizza.telran.pages;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.data.GenerateRandomData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateNewPizzaPage extends BasePage {
    public CreateNewPizzaPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='name']")
    WebElement pizzaNameInput;
    @FindBy(xpath = "//input[@id='size']")
    WebElement pizzaSizeInput;
    @FindBy(xpath = "//input[@id='key_ingredients']")
    WebElement pizzaIngredientsInput;
    @FindBy(xpath = "//input[@id='price']")
    WebElement pizzaPriceInput;
    @FindBy(xpath = "//select[@id='cafe']")
    WebElement pizzaCafeInput;
    public CreateNewPizzaPage createNewPizza(String pizzaName, String size, String ingredients, String pizzaPrice) {
        fillField(pizzaName, pizzaNameInput);
        fillField(size, pizzaSizeInput);
        fillField(ingredients, pizzaIngredientsInput);
        fillField(pizzaPrice, pizzaPriceInput);
        Select select = new Select(pizzaCafeInput);
        List<WebElement> selectedOptionList = select.getAllSelectedOptions();
        select.selectByIndex(new GenerateRandomData().generateRandomNumberInRange(0, selectedOptionList.size()));
        clickSubmit();
        return this;
    }
    public CreateNewPizzaPage createEmptyPizza() {
        clickSubmit();
        return this;
    }
    public CreateNewPizzaPage editPizza() {
        editItem(BaseConstants.EDIT_PARAM, pizzaSizeInput);
        return this;
    }
    public String pizzaName() {
        return new GenerateRandomData().generateFirstName();
    }
    public String pizzaPrice() {
        return Integer.toString(new GenerateRandomData().generateRandomNumberInRange(5, 20));
    }
}
