package com.pizza.telran.pages;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.data.GenerateRandomData;
import com.pizza.telran.data.PizzaTableConstant;
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
    public CreateNewPizzaPage createNewPizza() {
        PizzaTableConstant.PIZZA_NAME = new GenerateRandomData().generateFirstName();
        fillField(PizzaTableConstant.PIZZA_NAME, pizzaNameInput);
        fillField("Family", pizzaSizeInput);
        fillField(new GenerateRandomData().generateIngredients(), pizzaIngredientsInput);
        fillField(Integer.toString(new GenerateRandomData().generateRandomNumberInRange(5,20)), pizzaPriceInput);
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
}
