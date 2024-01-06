package com.pizza.telran.ui.tests;

import com.pizza.telran.pages.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserRightsTests extends BaseTests {
    @BeforeMethod
    public void prepare() {
        new HomePage(driver).clickToHeaderButtonLogInPage();
    }

    @Test
    public void isUserRightsOnPizzaPageTest() {
        new LoginPage(driver).loginWithBaseUserAccess();
        new HomePage(driver).clickToBodyButtonPizzas();
        Assert.assertTrue(new BasePage(driver).isElementExistOnPage(new BasePage(driver).cafeButton));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void isUserRightsHaveEditButtonOnPizzaPageTest() {
        new LoginPage(driver).loginWithBaseUserAccess();
        new HomePage(driver).clickToBodyButtonPizzas();
        Assert.assertFalse(new BasePage(driver).isElementExistOnPage(new BasePage(driver).editButton));
    }

    @Test
    public void isUserRightsOnCafePageTest() {
        new LoginPage(driver).loginWithBaseUserAccess();
        new HomePage(driver).clickToBodyButtonCafes();
        Assert.assertTrue(new BasePage(driver).isElementExistOnPage(new BasePage(driver).menuButton));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void isUserRightsHaveEditButtonOnCafesPageTest() {
        new LoginPage(driver).loginWithBaseUserAccess();
        new HomePage(driver).clickToBodyButtonCafes();
        Assert.assertFalse(new BasePage(driver).isElementExistOnPage(new BasePage(driver).editButton));
    }
}
