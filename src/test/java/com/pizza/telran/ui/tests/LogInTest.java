package com.pizza.telran.ui.tests;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.data.CafeTableConstant;
import com.pizza.telran.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest{
    @BeforeMethod
    public void prepare() {
        new HomePage(driver).clickToHeaderButtonLogInPage();
    }

    @Test
    public void loginWithUserAccess() {
        new LogInPage(driver).logInWithBaseUserAccess();
        new HomePage(driver).clickToBodyButtonPizzas();
        new PizzaPage(driver).clickOnRandomPizza();
        Assert.assertTrue(new CafeMenuPage(driver).isRightCafe(CafeTableConstant.MY_CAFE));
    }

    @Test
    public void loginWithAdminAccess() {
        new LogInPage(driver).logInWithBaseAdminAccess();
        new HomePage(driver).clickToHeaderButtonCafePage();
        Assert.assertTrue(new CafeListPage(driver).isButtonNewVisible());
    }

    @Test
    public void loginWithFakeUserLogin() {
        new LogInPage(driver).logInWithFakeLogin();
        Assert.assertTrue(new LogInPage(driver).getValidationText().contains("Invalid"));
        Assert.assertEquals(new LogInPage(driver).getValidationText(), BaseConstants.LOGIN_ERROR);
    }
}
