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
                new CreateNewCafePage(driver).newCompanyName(),
                new GenerateRandomData().generateCityOfCafe(),
                new GenerateRandomData().generateAddress(),
                new GenerateRandomData().generateEmail(),
                new GenerateRandomData().generateMobilePhone(),
                BaseConstants.CAFE_OPEN, BaseConstants.CAFE_CLOSE);
        Assert.assertTrue(new BasePage(driver).isElementExist(BaseConstants.NEW_COMPANY_NAME));
    }
    @Test
    public void createNewCafeWithCafeLongName() {
        new HomePage(driver).clickToHeaderButtonCafePage();
        new CafeListPage(driver).clickOnCreateNewCafeButton();
        new CreateNewCafePage(driver).createNewCafe(
                new CreateNewCafePage(driver).newCompanyName()
                        + new CreateNewCafePage(driver).newCompanyName()
                        + new CreateNewCafePage(driver).newCompanyName(),
                new GenerateRandomData().generateCityOfCafe(),
                new GenerateRandomData().generateAddress(),
                new GenerateRandomData().generateEmail(),
                new GenerateRandomData().generateMobilePhone(),
                BaseConstants.CAFE_OPEN, BaseConstants.CAFE_CLOSE);
        Assert.assertTrue(new BasePage(driver).errorElement().isDisplayed());
    }
    @Test
    public void createNewCafeWithCityLongName() {
        new HomePage(driver).clickToHeaderButtonCafePage();
        new CafeListPage(driver).clickOnCreateNewCafeButton();
        new CreateNewCafePage(driver).createNewCafe(
                new CreateNewCafePage(driver).newCompanyName(),
                new GenerateRandomData().generateCityOfCafe()
                        + new GenerateRandomData().generateCityOfCafe()
                        + new GenerateRandomData().generateCityOfCafe(),
                new GenerateRandomData().generateAddress(),
                new GenerateRandomData().generateEmail(),
                new GenerateRandomData().generateMobilePhone(),
                BaseConstants.CAFE_OPEN, BaseConstants.CAFE_CLOSE);
        Assert.assertTrue(new BasePage(driver).errorElement().isDisplayed());
    }
    @Test
    public void deleteCafe() {
        new HomePage(driver).clickToHeaderButtonCafePage();
        new CafeListPage(driver).deleteLastElementInTable();
        Assert.assertFalse(new BasePage(driver).isElementExist(BaseConstants.LAST_CAFE_NAME));
    }
    @Test
    public void createNewPizza() {
        new HomePage(driver).clickToBodyButtonPizzas();
        new PizzaPage(driver).clickOnCreateNewPizza();
        new CreateNewPizzaPage(driver).createNewPizza();
        Assert.assertTrue(new BasePage(driver).isElementExist(PizzaTableConstant.PIZZA_NAME));
    }
    @Test
    public void deletePizza() {
        new HomePage(driver).clickToBodyButtonPizzas();
        new CafeListPage(driver).deleteLastElementInTable();
        Assert.assertFalse(new BasePage(driver).isElementExist(PizzaTableConstant.PIZZA_NAME));
    }
    @Test
    public void createEmptyPizza() {
        new HomePage(driver).clickToBodyButtonPizzas();
        new PizzaPage(driver).clickOnCreateNewPizza();
        new CreateNewPizzaPage(driver).createEmptyPizza();
        Assert.assertTrue(new BasePage(driver).errorElement().isDisplayed());
    }
}
