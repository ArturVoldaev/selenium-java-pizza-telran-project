package com.pizza.telran.ui.tests;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.data.GenerateRandomData;
import com.pizza.telran.data.PizzaTableConstant;
import com.pizza.telran.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminRightsTest extends BaseTest {
    @BeforeMethod
    public void prepare() {
        new HomePage(driver).clickToHeaderButtonLogInPage();
        new LogInPage(driver).logInWithBaseAdminAccess();
    }
    @Test
    public void createNewCafe() {
        new HomePage(driver).clickToHeaderButtonCafePage();
        new CafeListPage(driver).clickOnCreateNewCafeButton();
        new CreateNewCafePage(driver).createNewCafe(
                BaseConstants.NEW_COMPANY_NAME,
                new GenerateRandomData().generateCityOfCafe(),
                new GenerateRandomData().generateAddress(),
                new GenerateRandomData().generateEmail(),
                new GenerateRandomData().generateMobilePhone(),
                BaseConstants.CAFE_OPEN, BaseConstants.CAFE_CLOSE);
        Assert.assertTrue(new BasePage(driver).isElementExistInTable(BaseConstants.NEW_COMPANY_NAME));
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
        new CafeListPage(driver).clickOnCreateNewCafeButton();
        new CreateNewCafePage(driver).createNewCafe(
                BaseConstants.NEW_COMPANY_NAME
                        + BaseConstants.NEW_COMPANY_NAME
                        + BaseConstants.NEW_COMPANY_NAME,
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
        new CafeListPage(driver).clickOnCreateNewCafeButton();
        new CreateNewCafePage(driver).createNewCafe(
                BaseConstants.NEW_COMPANY_NAME,
                new GenerateRandomData().generateCityOfCafe()
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
        new BasePage(driver).deleteLastElementInTable();
        Assert.assertFalse(new BasePage(driver).isElementExistInTable(BaseConstants.LAST_CAFE_NAME));
    }
    @Test
    public void createNewPizza() {
        new HomePage(driver).clickToBodyButtonPizzas();
        new PizzaPage(driver).clickOnCreateNewPizza();
        new CreateNewPizzaPage(driver).createNewPizza();
        Assert.assertTrue(new BasePage(driver).isElementExistInTable(PizzaTableConstant.PIZZA_NAME));
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
        new BasePage(driver).deleteLastElementInTable();
        Assert.assertFalse(new BasePage(driver).isElementExistInTable(PizzaTableConstant.PIZZA_NAME));
    }
    @Test
    public void createEmptyPizza() {
        new HomePage(driver).clickToBodyButtonPizzas();
        new PizzaPage(driver).clickOnCreateNewPizza();
        new CreateNewPizzaPage(driver).createEmptyPizza();
        Assert.assertTrue(new BasePage(driver).getErrorElement().isDisplayed());
    }
}
