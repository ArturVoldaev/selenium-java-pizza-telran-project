package com.pizza.telran.ui.tests;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void prepare() {
        new HomePage(driver).clickToHeaderButtonLogInPage();
    }

    @Test
    public void loginWithUserAccess() {
        new LoginPage(driver).loginWithBaseUserAccess();
        new HomePage(driver).clickToBodyButtonPizzas();
        List<Map<String, String>> parsePizzaTable = new BasePage(driver).parseTable();
        int randomNumberPizza = new BasePage(driver).generateRandomNumberOfActionButton();
        new PizzaPage(driver).clickOnRandomPizza(randomNumberPizza);
        Assert.assertEquals(
                new CafeMenuPage(driver).cafeName(),
                parsePizzaTable.get(randomNumberPizza - 1).get("Cafe")
        );
    }

    @Test
    public void loginWithAdminAccess() {
        new LoginPage(driver).loginWithBaseAdminAccess();
        new HomePage(driver).clickToHeaderButtonCafePage();
        Assert.assertTrue(new CafePage(driver).isButtonNewVisible());
    }

    @Test
    public void loginWithFakeUserLogin() {
        new LoginPage(driver).loginWithFakeLogin();
        Assert.assertTrue(new LoginPage(driver).getValidationText().contains("Invalid"));
        Assert.assertEquals(new LoginPage(driver).getValidationText(), BaseConstants.LOGIN_ERROR);
    }
}
