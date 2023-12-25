package com.pizza.telran.ui.tests;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.data.GenerateRandomData;
import com.pizza.telran.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


public class AdminRightsTest extends BaseTest {
    @BeforeMethod
    public void prepare() {
        new HomePage(driver).clickToHeaderButtonLogInPage();
        new LogInPage(driver).logInWithBaseAdminAccess();
    }
    @Test
    public void createNewCafe() {
        String newCafeName = new CreateNewCafePage(driver).newCafeName();
        new HomePage(driver).clickToHeaderButtonCafePage();
        new CafePage(driver).clickOnCreateNewCafeButton();
        new CreateNewCafePage(driver).createNewCafe(
                newCafeName,
                new GenerateRandomData().generateCityOfCafe(),
                new GenerateRandomData().generateAddress(),
                new GenerateRandomData().generateEmail(),
                new GenerateRandomData().generateMobilePhone(),
                BaseConstants.CAFE_OPEN, BaseConstants.CAFE_CLOSE);
        Assert.assertTrue(new BasePage(driver).isElementExistInTable(newCafeName));
    }
    @Test
    public void editCafe() {
        new HomePage(driver).clickToHeaderButtonCafePage();
        new BasePage(driver).editLastElementInTable();
        new CreateNewCafePage(driver).editCafe();
        Assert.assertTrue(new BasePage(driver).isElementExistInTable(BaseConstants.EDIT_PARAM));
    }
    @Test
    public void createNewCafeWithCafeLongName() {
        new HomePage(driver).clickToHeaderButtonCafePage();
        new CafePage(driver).clickOnCreateNewCafeButton();
        new CreateNewCafePage(driver).createNewCafe(
                new CreateNewCafePage(driver).newCafeName()
                        + new CreateNewCafePage(driver).newCafeName()
                        + new CreateNewCafePage(driver).newCafeName()
                        + new CreateNewCafePage(driver).newCafeName()
                        + new CreateNewCafePage(driver).newCafeName()
                        + new CreateNewCafePage(driver).newCafeName(),
                new GenerateRandomData().generateCityOfCafe(),
                new GenerateRandomData().generateAddress(),
                new GenerateRandomData().generateEmail(),
                new GenerateRandomData().generateMobilePhone(),
                BaseConstants.CAFE_OPEN, BaseConstants.CAFE_CLOSE);
        Assert.assertTrue(new BasePage(driver).getErrorElement().isDisplayed());
    }
    @Test
    public void createNewCafeWithCityLongName() {
        new HomePage(driver).clickToHeaderButtonCafePage();
        new CafePage(driver).clickOnCreateNewCafeButton();
        new CreateNewCafePage(driver).createNewCafe(
                new CreateNewCafePage(driver).newCafeName(),
                new GenerateRandomData().generateCityOfCafe()
                        + new GenerateRandomData().generateCityOfCafe()
                        + new GenerateRandomData().generateCityOfCafe()
                        + new GenerateRandomData().generateCityOfCafe()
                        + new GenerateRandomData().generateCityOfCafe()
                        + new GenerateRandomData().generateCityOfCafe(),
                new GenerateRandomData().generateAddress(),
                new GenerateRandomData().generateEmail(),
                new GenerateRandomData().generateMobilePhone(),
                BaseConstants.CAFE_OPEN, BaseConstants.CAFE_CLOSE);
        Assert.assertTrue(new BasePage(driver).getErrorElement().isDisplayed());
    }
    @Test
    public void deleteCafe() {
        new HomePage(driver).clickToHeaderButtonCafePage();
        List<Map<String, String>> beforeDelete = new BasePage(driver).parseTable();
        new BasePage(driver).deleteElementInTable();
        List<Map<String, String>> afterDelete = new BasePage(driver).parseTable();
        Assert.assertFalse(new BasePage(driver).checkParseData(beforeDelete, afterDelete));
    }
    @Test
    public void createNewPizza() {
        new HomePage(driver).clickToBodyButtonPizzas();
        new PizzaPage(driver).clickOnCreateNewPizza();
        String newNamePizza = new CreateNewPizzaPage(driver).pizzaName();
        new CreateNewPizzaPage(driver).createNewPizza(
                newNamePizza,
                "Family",
                new GenerateRandomData().generateIngredients(),
                new CreateNewPizzaPage(driver).pizzaPrice()
        );
        Assert.assertTrue(new BasePage(driver).isElementExistInTable(newNamePizza));
    }
    @Test
    public void editPizza() {
        new HomePage(driver).clickToBodyButtonPizzas();
        new BasePage(driver).editLastElementInTable();
        new CreateNewPizzaPage(driver).editPizza();
        Assert.assertTrue(new BasePage(driver).isElementExistInTable(BaseConstants.EDIT_PARAM));
    }
    @Test
    public void deletePizza() {
        new HomePage(driver).clickToBodyButtonPizzas();
        List<Map<String, String>> beforeDelete = new BasePage(driver).parseTable();
        new BasePage(driver).deleteElementInTable();
        List<Map<String, String>> afterDelete = new BasePage(driver).parseTable();
        Assert.assertFalse(new BasePage(driver).checkParseData(beforeDelete, afterDelete));
    }
    @Test
    public void createEmptyPizza() {
        new HomePage(driver).clickToBodyButtonPizzas();
        new PizzaPage(driver).clickOnCreateNewPizza();
        new CreateNewPizzaPage(driver).createEmptyPizza();
        Assert.assertTrue(new BasePage(driver).getErrorElement().isDisplayed());
    }
}
